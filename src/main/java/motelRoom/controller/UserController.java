package motelRoom.controller;

import motelRoom.dto.user.UserCreateDto;
import motelRoom.dto.user.UserDetailDto;
import motelRoom.service.userService.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /** ---------------- GET USER BY ID ------------------------ */
    @GetMapping("/info/{id}")
    public ResponseEntity<UserDetailDto> findById(@PathVariable UUID id){
        //viet them de test commit
        return ResponseEntity.ok(userService.findById(id));
    }

    /** ---------------- CREATE NEW USER ------------------------ */
    @PostMapping("/signup")
    public ResponseEntity<UserDetailDto> createUser(@RequestBody UserCreateDto userCreateDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.createUser(userCreateDto));
    }
}
