package motelRoom.service.userService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import motelRoom.repository.UserRepository;
import java.util.Random;


@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    JavaMailSender javaMailSender;

    @Override
    public void ChangePassword(String username){
        String newPassword = GenPass();
        userRepository.updatePasswords(username, newPassword);
        sendEmail(username,newPassword);
    }
    String GenPass()
    {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghi"
                +"jklmnopqrstuvwxyz!@#$%&";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(8);
        for (int i = 0; i < 8; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }
    void sendEmail(String mail, String nps) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(mail);
        msg.setSubject("New password for your account");
        msg.setText("Hi " + mail + "\nYour new password " + nps);
        javaMailSender.send(msg);
    }
}
