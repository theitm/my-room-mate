package motelRoom.service.userService;

import motelRoom.entity.UserEntity;
import motelRoom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Random;


@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    JavaMailSender javaMailSender;


    @Override
    public void ForgotPassword(String username) {
        UserEntity entity = userRepository.findByUsername(username);
        if(entity == null )
        {
            return;
        }
        String newPassword = GenPass();
        entity.setPasswords(newPassword);
        userRepository.saveAndFlush(entity);
        try {
            sendMail(username,newPassword);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    String GenPass()
    {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%&";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(8);
        for (int i = 0; i < 8; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }

    void sendMail(String mail,String password) throws MessagingException {
        MimeMessage mailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, true);
        messageHelper.setTo(mail);
        messageHelper.setSubject("Your new password");
        messageHelper.setText("Hi <b>" + mail +"</b>" +
                                "\nYour new password <p style=\"color:DeepSkyBlue\"><b>" + password + "</b></p>", true);
        javaMailSender.send(mailMessage);
    }
}
