package motelRoom.service.userService;

import motelRoom.dto.user.UserCreateDto;
import motelRoom.dto.user.UserDetailDto;
import motelRoom.entity.UserEntity;
import motelRoom.mapper.UserMapper;
import motelRoom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Random;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    UserMapper userMapper;
    /**
     * Create 1 User
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
     * get 1 User by id
     */
    @Override
    public UserDetailDto findById(UUID id) {
        return userMapper.fromUserEntityToUserCrateDto(userRepository.getById(id));
    }
    /**
     * Forgot Password
     * send new password to username(email)
     */
    @Override
    public String forgotPassword(String username) {
        UserEntity entity = userRepository.findByUsername(username);
        if (entity == null)
        {
            return null;
        }
        String newPassword = generateNewPassword(); //generate new password
        entity.setPassword(newPassword); //set new password
        userRepository.saveAndFlush(entity);
        try {
            sendMail(username,newPassword); //send mail to email(username)
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return entity.getUsername();
    }
    /**
     * generate new password
     */
    String generateNewPassword()
    {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%&";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(8);
        for (int i = 0; i < 8; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }
    /**
     * send mail new password for user(email)
     */
    void sendMail(String mail,String password) throws MessagingException {
        MimeMessage mailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, true); //multipart true
        messageHelper.setTo(mail); //set mailto
        messageHelper.setSubject("Your new password");
        messageHelper.setText("Hi <b>" + mail +"</b>" +
                                "\nYour new password <p style=\"color:DeepSkyBlue\"><b>" + password + "</b></p>", true);
        javaMailSender.send(mailMessage);
    }
}
