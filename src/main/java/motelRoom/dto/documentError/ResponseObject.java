package motelRoom.dto.documentError;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class ResponseObject {
    private String status;
    private String message;
    private Object data;
}
