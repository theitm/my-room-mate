package motelRoom.service.userService;

import motelRoom.dto.user.UserCreateDto;
import motelRoom.dto.user.UserDetailDto;
import motelRoom.entity.UserEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public interface UserService {
    UserDetailDto createUser(UserCreateDto  userCreateDto);
    UserDetailDto updateUser(UUID id,  UserDetailDto userDetailDto);
    UserDetailDto findById(UUID id);
    void deleteById( UUID id);
    List<UserDetailDto> findAll();
    /**.....Forgot Password...........**/
    String forgotPassword(String username);

    String changePassword(String username,String newPassword);
    public boolean checkIfValidOldPassword(final String username, final String oldPassword);


}
