package motelRoom.service.userService;

import org.springframework.stereotype.Service;
import motelRoom.dto.user.UserCreateDto;
import motelRoom.dto.user.UserDetailDto;
import org.springframework.stereotype.Service;
import motelRoom.dto.user.UserLogin;
import java.util.List;
import java.util.UUID;
@Service
public interface UserService {

    /**.....Forgot Password...........**/
    String forgotPassword(String username);
    UserDetailDto createUser(UserCreateDto  userCreateDto);
    UserDetailDto updateUser(UUID id,  UserDetailDto userDetailDto);
    UserDetailDto findById(UUID id);
    void deleteById( UUID id);
    List<UserDetailDto> findAll();

}
