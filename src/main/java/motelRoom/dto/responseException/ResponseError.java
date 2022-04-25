package motelRoom.dto.responseException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class ResponseError  {
    private HttpStatus error;
    private String message;
}
