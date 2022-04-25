package motelRoom.controller;

import motelRoom.JWT.JwtTokenProvider;
import motelRoom.JWT.LoginResponse;
import motelRoom.JWT.RandomStuff;
import motelRoom.dto.user.UserCreateDto;
import motelRoom.dto.user.UserDetailDto;
import motelRoom.dto.user.UserLogin;
import motelRoom.entity.UserEntity;
import motelRoom.service.exceptionService.BadRequestException;
import motelRoom.service.userService.CustomUserDetails;
import motelRoom.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider tokenProvider;

    /** ---------------- GET USER BY ID ------------------------ */
    @GetMapping("/{id}")
    public ResponseEntity<UserDetailDto> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    /** ---------------- GET ALL USER ------------------------ */
    @GetMapping("/all")
    public List<UserDetailDto> findAll() {
        return userService.findAll();
    }

    /** ---------------- CREATE NEW USER ------------------------ */
    @PostMapping("/signup")
    public ResponseEntity<UserDetailDto> createUser(@RequestBody UserCreateDto userCreateDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.createUser(userCreateDto));
    }

    /** ---------------- UPDATE NEW USER ------------------------ */
    @PutMapping("/{id}")
    public ResponseEntity<UserDetailDto> updateUser(@PathVariable UUID id,
                                                    @RequestBody UserCreateDto userCreateDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.createUser(userCreateDto));
    }

    /** ---------------- LOGIN USER ------------------------ */
    @PostMapping("/login")
    public LoginResponse authenticateUser(@Valid @RequestBody UserLogin userLogin) {
        /**Xác thực từ username và password.*/
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userLogin.getUsername(),
                        userLogin.getPassword()
                )
        );
        /**Nếu không xảy ra exception tức là thông tin hợp lệ
         // Set thông tin authentication vào Security Context*/
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Trả về jwt cho người dùng.
        String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
        return new LoginResponse(jwt);
    }

    // Api /api/random yêu cầu phải xác thực mới có thể request
    @GetMapping("/random")
    public RandomStuff randomStuff() {
        return new RandomStuff("JWT Hợp lệ mới có thể thấy được message này");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable UUID id) {
        userService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    /** ---------------- Forgot Password ------------------------ */
    @PutMapping("/ForgotPassword/{username}")
    public String forgotPassword(@PathVariable(name = "username") String username)
    {
        return userService.forgotPassword(username);
    }

    /** ---------------- Change Password ------------------------ */
    @PutMapping("/ChangePassword")
    public String changePassword( @RequestParam(value = "newPassword") String newPassword,
                                  @RequestParam(value = "oldPassword") String oldPassword)
    {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if(!userService.checkIfValidOldPassword(username, oldPassword))
        {
           throw new BadRequestException("Password not invalid");
        }
        return userService.updatePassword(username, newPassword);
    }

    /** ---------------- GET USER CURRENT  ------------------------ */
    @GetMapping("/me")
    public Object currentUserDetail(Authentication authentication) {
        return userService.findByUserName(authentication.getName());
    }
}