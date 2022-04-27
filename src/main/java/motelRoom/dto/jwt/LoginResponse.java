package motelRoom.dto.jwt;

import lombok.Data;
import motelRoom.dto.user.UserDetailDto;

@Data
public class LoginResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private UserDetailDto userDetailDto;

    public LoginResponse(String accessToken, UserDetailDto userDetailDto) {
        this.accessToken = accessToken;
        this.userDetailDto = userDetailDto;
    }
}
