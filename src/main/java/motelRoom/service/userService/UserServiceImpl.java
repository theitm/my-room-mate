package motelRoom.service.userService;

import motelRoom.dto.user.UserCreateDto;
import motelRoom.dto.user.UserDetailDto;

import motelRoom.entity.UserEntity;
import motelRoom.mapper.UserMapper;
import motelRoom.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapperr) {
        this.userRepository = userRepository;
        this.userMapper = userMapperr;
    }

    /**
     * Tạo mới 1 User
     */
    @Override
    public UserDetailDto createUser(UserCreateDto userCreateDto) {
        UserEntity userEntity = userMapper.fromUserEntityCreateDtoToEntity(userCreateDto);
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
        UserDetailDto userDetailDto= userMapper.fromUserEntityToUserCrateDto(userRepository.getById(id));
        return userDetailDto;
    }


}
