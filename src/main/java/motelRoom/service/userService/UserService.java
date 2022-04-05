package motelRoom.service.userService;

import org.springframework.stereotype.Service;
import motelRoom.dto.user.UserCreateDto;
import motelRoom.dto.user.UserDetailDto;

import java.util.UUID;
@Service
public interface UserService {
    UserDetailDto createUser(UserCreateDto userCreateDto);
    UserDetailDto findById(UUID id);
    String forgotPassword(String username);
}
