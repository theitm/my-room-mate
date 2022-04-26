package motelRoom.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailDto implements Serializable {
    private UUID id;

    private String username;

    private String role;

    private String fullName;

    private Date birthDate;

    private String phoneNumber;

    private int gender;

    private String facebook;

    private String avatarUrl;
}
