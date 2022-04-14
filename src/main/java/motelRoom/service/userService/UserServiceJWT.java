package motelRoom.service.userService;

import motelRoom.entity.UserEntity;
import motelRoom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class UserServiceJWT implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Override phương thức trong class UserDetailsService
     * @param username
     * @return UserDetailsImpl là implements của UserDetails (UserDetails là đối tượng Spring security sử dụng để authen và authorize)
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username){
        /**Kiểm tra xem user có tồn tại hay không?*/
        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity==null){
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(userEntity);
    }

    /** JWTAuthenticationFilter sẽ sử dụng hàm này*/
    @Transactional
    public UserDetails loadUserById(UUID id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id : " + id)
        );
        return new CustomUserDetails(userEntity);
    }
}
