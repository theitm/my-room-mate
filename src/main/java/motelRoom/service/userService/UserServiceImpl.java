package motelRoom.service.userService;

import com.sun.xml.bind.v2.schemagen.XmlSchemaGenerator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import motelRoom.dto.user.UserCreateDto;
import motelRoom.dto.user.UserDetailDto;
import motelRoom.entity.UserEntity;
import motelRoom.mapper.UserMapper;
import motelRoom.repository.UserRepository;


import java.util.Base64;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Autowired
    JavaMailSender javaMailSender;

    /**
     * get user by ID
     * @param user_id
     * @return
     */
    public UserDetailDto findById(UUID user_id) {
        UserDetailDto userDetailDto = userMapper.fromEntityToDto(userRepository.getById(user_id));
        return userDetailDto;
    }

    /**
     * get all user
     * @return
     */
    public List<UserDetailDto> findAll() {
        return userMapper.fromListEntityToDto(userRepository.findAll());
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
            //userDetailDto = userMapper.fromEntityToDto(userEntityCreate);
            UserEntity userEntity = userMapper.fromUserCreateDto(userCreateDto);
            UserEntity userEntityCreate = userRepository.save(userEntity);
            //ok
        }
            return null;

    }
    /**
     * update user by id
     * @param
     * @return
     */
    @Override
    public  UserDetailDto updateUser(UUID id ,  UserDetailDto userDetailDto) {
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        if(userEntity == null){
            return null;
        }
        BeanUtils.copyProperties(userDetailDto, userEntity);
        userRepository.saveAndFlush(userEntity);
        userDetailDto = userMapper.fromEntityToDto(userEntity);
        return userDetailDto;
    }
    /**
     * delete user by id
     * @param
     * @return
     */
    public void deleteById(UUID id) {
        userRepository.deleteById(id);
    }
}
