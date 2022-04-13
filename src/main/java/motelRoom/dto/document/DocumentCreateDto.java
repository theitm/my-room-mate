package motelRoom.dto.document;
import lombok.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentCreateDto {
    private UUID roomId;
    private String roomUrl;
    private UUID evaluationId;
    private String evaluationUrl;
}
