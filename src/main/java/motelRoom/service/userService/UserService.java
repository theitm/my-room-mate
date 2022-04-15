package motelRoom.service.userService;

import motelRoom.dto.user.UserCreateDto;
import motelRoom.dto.user.UserDetailDto;
import org.springframework.stereotype.Service;
import motelRoom.dto.user.UserLogin;
import java.util.List;
import java.util.UUID;
@Service
public interface UserService {
   UserDetailDto createUser(UserCreateDto  userCreateDto);
    UserDetailDto updateUser(UUID id , UserDetailDto userDetailDto);
    List<UserDetailDto> findAll();
    UserDetailDto findById(UUID id);
    void deleteById( UUID id);
    List<UserLogin> findAllAcc();

}
