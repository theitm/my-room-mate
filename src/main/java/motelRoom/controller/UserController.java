package motelRoom.controller;

import motelRoom.dto.user.UserCreateDto;
import motelRoom.dto.user.UserDetailDto;
import motelRoom.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import motelRoom.JWT.JwtTokenProvider;
import motelRoom.JWT.LoginResponse;
import motelRoom.JWT.RandomStuff;
import motelRoom.dto.user.UserLogin;
import motelRoom.service.userService.CustomUserDetails;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider tokenProvider;

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /** ---------------- GET USER BY ID ------------------------ */
    @GetMapping("/{id}")
    public ResponseEntity<UserDetailDto> findById(@PathVariable UUID id){
        return ResponseEntity.ok(userService.findById(id));
    }

    /** ---------------- GET ALL USER ------------------------ */
    @GetMapping("/all")
    public  List<UserDetailDto> findAllAcc() { return userService.findAll(); }

    /** ---------------- CREATE NEW USER ------------------------ */
    @PostMapping("/signup")
    public ResponseEntity<UserDetailDto> createUser(@RequestBody UserCreateDto userCreateDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.createUser(userCreateDto));
    }

    /** ---------------- UPDATE NEW USER ------------------------ */
    @PutMapping("/{id}")
    public ResponseEntity<UserDetailDto> updateUser(@PathVariable UUID id,
                                                    @RequestBody UserCreateDto userCreateDto)
    {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.createUser(userCreateDto));
    }

    /** ---------------- LOGIN USER ------------------------ */
    @PostMapping("/login")
    public LoginResponse authenticateUser (@Valid @RequestBody UserLogin userLogin) {
        /**Authenticate from username and password.*/
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userLogin.getUsername(),
                        userLogin.getPassword()
                )
        );
        /**If no exception occurs, the information is valid
         // Set authentication information to Security Context*/
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
        return new LoginResponse(jwt);
    }

    @GetMapping("/random")
    public RandomStuff randomStuff(){
        return new RandomStuff("JWT Hợp lệ mới có thể thấy được message này");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable UUID id) {
        userService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}