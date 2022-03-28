package motelRoom.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDto implements Serializable {
    private UUID user_id;
    private String username;
    private String passwords;
    private String roles;
    private String full_name;
    private Date birth_date;
    private String phone_number;
    private int gender;
    private String fb;
    private String url_avatar;
}
