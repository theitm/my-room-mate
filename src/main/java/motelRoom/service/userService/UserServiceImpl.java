package motelRoom.service.userService;

import motelRoom.dto.user.UserCreateDto;
import motelRoom.dto.user.UserDetailDto;
import motelRoom.dto.user.UserLogin;
import motelRoom.entity.UserEntity;
import motelRoom.mapper.UserMapper;
import motelRoom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    /**
     * lấy thông tin 1 User theo id
     */
    @Override
    public UserDetailDto findById(UUID id) {
        return userMapper.fromUserEntityToUserCrateDto(userRepository.getById(id));
    }

    /**
     * lấy thông tin tất cả tài khoản User theo id
     */
    @Override
    public List<UserLogin> findAllAcc() {
        return userMapper.fromListDtosToEntities(userRepository.findAll());
    }

    @Override
    public List<UserDetailDto> findAll(){
        return userMapper.fromEntityToDto(userRepository.findAll());
    }

    /**
     * create new user
     * Account name does not match
     * @param userCreateDto
     * @return
     */
    @Override
    public UserDetailDto createUser(UserCreateDto userCreateDto) {
        String username = userCreateDto.getUsername();
        UserEntity entity = userRepository.findByUsername(username);
        if (entity == null ) {
            UserEntity userEntity = userMapper.fromUserEntityCreateDtoToEntity(userCreateDto);
            userEntity.setPassword(passwordEncoder.encode(userCreateDto.getPassword()));
            UserEntity userEntityCreate = userRepository.save(userEntity);
            UserDetailDto userDetailDto =null;
            if(userEntityCreate != null) {
                userDetailDto = userMapper.fromUserEntityToUserCrateDto(userEntityCreate);
            }
            return userDetailDto;
        }
        return null;
    }

    /**
     * update user by id
     * @param
     * @return
     */
    @Override
    public  UserDetailDto updateUser(UUID id,  UserDetailDto userDetailDto) {
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        if(userEntity == null){
            return null;
        }
        BeanUtils.copyProperties(userDetailDto, userEntity);
        userRepository.saveAndFlush(userEntity);
        userDetailDto = userMapper.fromUserEntityToUserCrateDto(userEntity);
        return userDetailDto;
    }

    /**
     * delete user by id
     * @param
     * @return
     */
    @Override
    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }
}