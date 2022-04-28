package motelRoom.service.userService;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import motelRoom.dto.user.UserCreateDto;
import motelRoom.dto.user.UserDetailDto;
import motelRoom.entity.UserEntity;
import motelRoom.mapper.UserMapper;
import motelRoom.repository.UserRepository;
import motelRoom.service.exceptionService.BadRequestException;
import motelRoom.service.exceptionService.NotAcceptable;
import motelRoom.service.exceptionService.NotFoundException;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.StringWriter;
import java.util.*;

@Service
public class UserServiceImpl implements UserService{
    private static final String CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    Configuration configuration;
    @Autowired
    UserRepository userRepository;
    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    /**
     * get user by id
    /**
     * show user detail by id
     */
    @Override
    public UserDetailDto findById(UUID id) {
        try {
            return userMapper.fromUserEntityToUserCrateDto(userRepository.getById(id));
        }
        catch (Exception e)
        {
            throw new NotAcceptable("can't find user with id: " + id );
        }
    }

    /**
     * show user detail by username
     */
    @Override
    public UserDetailDto findByUserName(String username) {
        return userMapper.fromUserEntityToUserCrateDto(userRepository.findByUsername(username));
    }

    /**
     * get list user detail
     */
    @Override
    public List<UserDetailDto> findAll(){
        return userMapper.fromEntitiesToDtos(userRepository.findAll());
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
            if (entity == null) {
                UserEntity userEntity = userMapper.fromUserEntityCreateDtoToEntity(userCreateDto);
                userEntity.setPassword(passwordEncoder.encode(userCreateDto.getPassword()));
                UserEntity userEntityCreate = userRepository.save(userEntity);
                UserDetailDto userDetailDto = null;
                if (userEntityCreate != null) {
                    userDetailDto = userMapper.fromUserEntityToUserCrateDto(userEntityCreate);
                }
                return userDetailDto;
            }
       throw new NotAcceptable("Username available");
    }

    /**
     * update user by id
     * @param
     * @return
     */
    @Override
    public UserDetailDto updateUser(UUID id, UserDetailDto userDetailDto) {
        try {
            UserEntity userEntity = userRepository.findById(id).orElse(null);
            if (userEntity == null) {
                return null;
            }
            BeanUtils.copyProperties(userDetailDto, userEntity);
            userRepository.saveAndFlush(userEntity);
            userDetailDto = userMapper.fromUserEntityToUserCrateDto(userEntity);
            return userDetailDto;
        }
        catch (Exception e)
        {
            throw new NotAcceptable("can't find user with id: " + id );
        }
    }

    /**
     * delete user by id
     * @param
     * @return
     */
    @Override
    public void deleteById(UUID id) {
        try {
            userRepository.deleteById(id);
        }
        catch (Exception e)
        {
            throw new NotAcceptable("can't find user with id: " + id +" to delete!");
        }
    }

    /**
     * Update password
     * @param username
     * @param newPassword
     * @return
     */
    @Override
    public String updatePassword(String username, String newPassword) {
        UserEntity entity = userRepository.findByUsername(username);
        entity.setPassword(passwordEncoder.encode(newPassword));
        userRepository.saveAndFlush(entity);
        return entity.getUsername();
    }

    /**
     * Verify your account's password
     * @param username
     * @param oldPassword
     * @return
     */
    @Override
    public boolean checkIfValidOldPassword(String username, String oldPassword) {
        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity == null)
        {
            throw new NotFoundException("Not find user");
        }
        return passwordEncoder.matches(oldPassword, userEntity.getPassword());
    }

    /**
     * Forgot Password
     * send random new password to username(email)
     */
    @Override
    public String forgotPassword(String username) {
        if(!isValidEmail(username)) {
            throw new BadRequestException("Email address is not valid");
        };
        UserEntity entity = userRepository.findByUsername(username); //tìm user trong DB bằng username
        if (entity == null)
        {
            throw new NotFoundException("Not find user");
        }
        String newPassword = generateNewPassword(); //generate new password
        entity.setPassword(passwordEncoder.encode(newPassword)); //set new password
        userRepository.saveAndFlush(entity);
        try {
            sendmail(entity, newPassword);
        } catch (MessagingException | TemplateException | IOException e) {
            e.printStackTrace();
        }
        return entity.getUsername();
    }

    /**
     * validator email
     * @param email
     * @return
     */
    public static boolean isValidEmail(String email) {
        EmailValidator validator = EmailValidator.getInstance();
        return validator.isValid(email);
    }

    /**
     * generate random new password
     */
    String generateNewPassword()
    {
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(8);
        for (int i = 0; i < 8; i++)
            sb.append(CHARS.charAt(rnd.nextInt(CHARS.length())));
        return sb.toString();
    }

    /**
     * send mail new password for user(email)
     */
    public void sendmail(UserEntity entity, String password) throws MessagingException, TemplateException, IOException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setSubject("Your new password");
        helper.setTo(entity.getUsername()); //username is email
        String content = getEmailContent(entity.getFullName(),password); //
        helper.setText(content, true); //allow send HTML
        javaMailSender.send(mimeMessage);
    }

    /**
     * convert template and variable to string
     */
    String getEmailContent(String fullName,String password) throws IOException, TemplateException {
        StringWriter stringWriter = new StringWriter();
        Map<String, String> model = new HashMap<>(); //transmission data to template HTML
        model.put("fullName", fullName);
        model.put("password",password);
        configuration.getTemplate("templateForgotPassword.ftlh").process(model,stringWriter);
        return stringWriter.getBuffer().toString();
    }
}

