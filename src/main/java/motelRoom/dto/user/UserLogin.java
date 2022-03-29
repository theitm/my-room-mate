package motelRoom.dto.user;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
public class UserLogin{

    @NotEmpty(message = "Thiếu username")
    @Email(message = "Email không hợp lệ")
    private String username;

    @NotEmpty(message = "Thiếu password")
    @Min(value = 6, message = "Password phải từ 6 kí tự trở lên")
    private String password;
}
