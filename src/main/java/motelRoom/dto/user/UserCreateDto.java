package motelRoom.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import motelRoom.service.customAnnotaion.Email;
import motelRoom.service.customAnnotaion.Password;
import motelRoom.service.customAnnotaion.Phone;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDto implements Serializable {

    @Email
    private String username;

    @Password
    private String password;

    private String role;

    private String fullName;

    private Date birthDate;

    @Phone
    private String phoneNumber;

    private int gender;

    private String facebook;

    private String avatarUrl;
}
