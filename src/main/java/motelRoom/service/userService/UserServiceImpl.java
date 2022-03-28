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
        UserEntity createdUser = userRepository.save(userEntity);
        UserDetailDto userDetailDto =null;
        if (createdUser != null) {
            userDetailDto = userMapper.fromUserEntityToUserCrateDto(createdUser);
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


}
