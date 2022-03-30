package motelRoom.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDto implements Serializable {

    private String username;

    private String password;

    private String role;

    private String fullName;

    private Date birthDate;

    private String phoneNumber;

    private int gender;

    private String fb;

    private String urlAvatar;
}
