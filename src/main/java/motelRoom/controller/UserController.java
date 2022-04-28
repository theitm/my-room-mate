package motelRoom.controller;

import motelRoom.service.jwt.JwtTokenProvider;
import motelRoom.dto.jwt.LoginResponse;
import motelRoom.dto.jwt.RandomStuff;
import motelRoom.dto.user.UserCreateDto;
import motelRoom.dto.user.UserDetailDto;
import motelRoom.dto.user.UserLogin;
import motelRoom.service.exceptionService.BadRequestException;
import motelRoom.service.exceptionService.NotAcceptable;
import motelRoom.service.userService.CustomUserDetails;
import motelRoom.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
@RestController
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
    public ResponseEntity<UserDetailDto> createUser(@RequestBody @Valid UserCreateDto userCreateDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.createUser(userCreateDto));
    }

    /** ---------------- UPDATE NEW USER ------------------------ */
    @PutMapping("/{id}")
    public ResponseEntity<UserDetailDto> updateUser(@PathVariable UUID id,
                                                    @RequestBody UserDetailDto userDetailDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.updateUser(id,userDetailDto));
    }

    /** ---------------- LOGIN USER ------------------------ */
    @PostMapping("/login")
    public LoginResponse authenticateUser(@Valid @RequestBody UserLogin userLogin,
                                          Authentication authentication){
        try {

                /**Xác thực từ username và password.*/
                authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                userLogin.getUsername(),
                                userLogin.getPassword()
                        )
                );
                /**If no exception occurs, the information is valid
                 // Set authentication information to Security Context*/
                SecurityContextHolder.getContext().setAuthentication(authentication);
                String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
                UserDetailDto userDetailDto= userService.findByUserName(authentication.getName());
                return new  LoginResponse(jwt, userDetailDto);
        }
        catch (Exception e)
        {
            throw new NotAcceptable("Username or password incorrect");
        }
    }

    @GetMapping("/random")
    public RandomStuff randomStuff() {
        return new RandomStuff("Only valid JWT can see this message");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable UUID id) {
        userService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    /** ---------------- Forgot Password ------------------------ */
    @PutMapping("/forgotpassword/{username}")
    public String forgotPassword(@PathVariable(name = "username") String username)
    {
        return userService.forgotPassword(username);
    }

    /** ---------------- Change Password ------------------------ */
    @PutMapping("/changepassword")
    public String changePassword( @RequestParam(value = "newpassword") String newPassword,
                                  @RequestParam(value = "oldpassword") String oldPassword)
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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}