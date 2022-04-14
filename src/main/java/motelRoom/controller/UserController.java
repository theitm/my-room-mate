package motelRoom.controller;

import motelRoom.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import motelRoom.dto.user.UserCreateDto;
import motelRoom.dto.user.UserDetailDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;
@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserService userService;

    /** ---------------- GET USER BY ID ------------------------ */
    @GetMapping("/info/{id}")
    public ResponseEntity<UserDetailDto> findById(@PathVariable UUID id){
        return ResponseEntity.ok(userService.findById(id));
    }

    /** ---------------- Forgot Password ------------------------ */
    @PutMapping("/ForgotPassword/{username}")
    public String ForgotPassword(@PathVariable(name = "username") String username)
    {
        return userService.forgotPassword(username);
    }
}
