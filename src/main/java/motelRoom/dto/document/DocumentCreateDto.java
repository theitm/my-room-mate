package motelRoom.dto.document;
import lombok.*;
import java.util.UUID;
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentCreateDto {
    private UUID roomId;
    private String urlRoom;
    private UUID evaluationId;
    private String urlEvaluation;
}
