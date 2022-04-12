package motelRoom.service.userService;

import motelRoom.dto.user.UserCreateDto;
import motelRoom.dto.user.UserDetailDto;

import java.util.UUID;


public interface UserService {

    UserDetailDto createUser(UserCreateDto userCreateDto);
    UserDetailDto findById(UUID id);

//    UserDetailDto login(UserLogin userLogin);
}
