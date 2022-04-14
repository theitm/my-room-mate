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
     * Tạo mới 1 User
     */
    @Override
    public UserDetailDto createUser(UserCreateDto userCreateDto) {
        UserEntity userEntity = userMapper.fromUserEntityCreateDtoToEntity(userCreateDto);
        userEntity.setPassword(passwordEncoder.encode(userCreateDto.getPassword()));
        UserEntity CreateUser = userRepository.save(userEntity);
        UserDetailDto userDetailDto =null;
        if (CreateUser != null){
            userDetailDto = userMapper.fromUserEntityToUserCrateDto(CreateUser);
        }
        return userDetailDto;
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
}
