package motelRoom.controller;

import motelRoom.dto.user.UserCreateDto;
import motelRoom.dto.user.UserDetailDto;
import motelRoom.repository.UserRepository;
import motelRoom.service.userService.UserService;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }



    @Autowired
    private UserRepository userRepository;


    /**
     * ---------------- CREATE NEW USER ------------------------
     */
    @PostMapping
    public ResponseEntity<UserDetailDto> create(@RequestBody UserCreateDto userCreateDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.createUser(userCreateDto));
    }

    /**
     * ---------------- GET USER BY ID ------------------------
     */
    @GetMapping("/{user_id}")
    public ResponseEntity<UserDetailDto> findById(@PathVariable UUID user_id) {
        return ResponseEntity.ok(userService.findById(user_id));
    }

    /**
     * ---------------- UPDATE USER ------------------------
     */
    @PutMapping("/{id}")
    public ResponseEntity<UserDetailDto> update(@PathVariable UUID id,
                                                @RequestBody UserDetailDto userDetailDto) {
         userDetailDto = userService.updateUser(id, userDetailDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userDetailDto);
    }

    /**
     * ---------------- GET ALL USER ------------------------
     */
    @GetMapping
    public List<UserDetailDto> findAll() {
        return userService.findAll();
    }

    /**
     * ---------------- DELETE USER BY ID ------------------------
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable UUID id) {
        userService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
