package motelRoom.service.userService;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

    String ForgotPassword(String username);
}
