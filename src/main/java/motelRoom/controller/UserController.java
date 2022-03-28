package motelRoom.controller;

import motelRoom.dto.user.UserCreateDto;
import motelRoom.dto.user.UserDetailDto;
import motelRoom.entity.UserEntity;
import motelRoom.mapper.UserMapper;
import motelRoom.repository.UserRepository;
import motelRoom.service.userService.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


/** ---------------- CREATE NEW COUNTRY ------------------------ */
    @PostMapping
    public ResponseEntity<UserDetailDto> create(@RequestBody UserCreateDto userCreateDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.createUser(userCreateDto));
    }

    /** ---------------- GET COUNTRY BY ID ------------------------ */
    @GetMapping("/{user_id}")
    public ResponseEntity<UserDetailDto> findById(@PathVariable UUID user_id) {
        return ResponseEntity.ok(userService.findById(user_id));
    }

    /** ---------------- UPDATE COUNTRY ------------------------ */
    @PutMapping("/{id}")
    public ResponseEntity<UserDetailDto> update(@PathVariable UUID id,
                                                   @RequestBody UserCreateDto userCreateDto) {
        UserDetailDto userDetailDto = userService.updateUser(id, userCreateDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userDetailDto);
    }

    /** ---------------- GET ALL COUNTRY ------------------------ */
    @GetMapping
    public List<UserDetailDto> findAll() {
        return userService.findAll();
    }

    /** ---------------- DELETE COUNTRY BY ID ------------------------ */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable UUID id) {
        userService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
