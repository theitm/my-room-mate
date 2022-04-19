package motelRoom.service.userService;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import motelRoom.dto.user.UserDetailDto;
import motelRoom.entity.UserEntity;
import motelRoom.mapper.UserMapper;
import motelRoom.repository.UserRepository;
import motelRoom.service.exceptionService.BadRequestException;
import motelRoom.service.exceptionService.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.apache.commons.validator.routines.EmailValidator;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{
    private static final String CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    @Autowired
    Configuration configuration; //config for freemarker
    @Autowired
    UserRepository userRepository;
    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    UserMapper userMapper;

    /**
     * get 1 User by id
     */
    @Override
    public UserDetailDto findById(UUID id) {
        return userMapper.fromUserEntityToUserCrateDto(userRepository.getById(id));
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
        entity.setPassword(newPassword); //set new password
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
