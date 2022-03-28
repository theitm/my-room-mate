package motelRoom.service.userService;

import org.springframework.stereotype.Service;

import motelRoom.dto.user.UserCreateDto;
import motelRoom.dto.user.UserDetailDto;
import motelRoom.entity.UserEntity;
import motelRoom.mapper.UserMapper;
import motelRoom.repository.UserRepository;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    /**
     * Hiện user theo ID
     * @param id
     * @return
     */
    public UserDetailDto findById(UUID user_id) {
        UserDetailDto userDetailDto = userMapper.fromEntityToDto(userRepository.getById(user_id));
        return userDetailDto;
    }

    /**
     * Hiện danh sách các user
     * @return
     */
    public List<UserDetailDto> findAll() {
        return userMapper.fromListEntityToDto(userRepository.findAll());
    }

    /**
     * Tạo một user mới
     * @param userCreateDto
     * @return
     */
    public UserDetailDto createUser(UserCreateDto userCreateDto) {

        UserEntity userEntity = userMapper.fromUserCreateDto(userCreateDto);
        UserEntity userEntityCreate = userRepository.save(userEntity);
        UserDetailDto userDetailDto =null;
        if(userEntityCreate != null) {
            userDetailDto = userMapper.fromEntityToDto(userEntityCreate);
        }
        return userDetailDto;
    }
    /**
     * Cập nhập một user theo id
     * @param
     * @return
     */
    public  UserDetailDto updateUser(UUID id ,  UserCreateDto  userCreateDto) {
        UserEntity userEntity = userMapper.fromUserCreateDto(userCreateDto);
        userEntity.setUser_id(id);
        userRepository.save(userEntity);
        UserDetailDto userDetailDto = userMapper.fromEntityToDto(userEntity);
        return userDetailDto;
    }
    /**
     * Xóa một user theo id
     * @param
     * @return
     */
    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }

}
