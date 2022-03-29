package motelRoom.service.userService;

import motelRoom.dto.user.UserCreateDto;
import motelRoom.dto.user.UserDetailDto;
import motelRoom.dto.user.UserLogin;


import java.util.List;
import java.util.UUID;


public interface UserService {

    UserDetailDto createUser(UserCreateDto userCreateDto);
    UserDetailDto findById(UUID id);

    List<UserLogin> findAllACC();

}
