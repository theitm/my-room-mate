package motelRoom.dto.responseException;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseObject {
    private String status;
    private String message;
    private Object data;
}
