package motelRoom.controller;

import motelRoom.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/ForgotPassword/{username}")
    public String ForgotPassword(@PathVariable(name = "username") String username)
    {
       return userService.ForgotPassword(username);
    }

}
