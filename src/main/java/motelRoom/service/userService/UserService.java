package motelRoom.service.userService;

import org.springframework.stereotype.Service;
import motelRoom.dto.user.UserCreateDto;
import motelRoom.dto.user.UserDetailDto;

import java.util.UUID;
@Service
public interface UserService {
    UserDetailDto findById(UUID id);
    /**.....Forgot Password...........**/
    String forgotPassword(String username);
}
