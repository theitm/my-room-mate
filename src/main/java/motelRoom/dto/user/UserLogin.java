package motelRoom.dto.user;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserLogin{
    private String username;
    private String password;
}