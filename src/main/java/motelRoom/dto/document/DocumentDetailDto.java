package motelRoom.dto.document;
import lombok.*;
import java.io.Serializable;
import java.util.UUID;
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentDetailDto implements Serializable {
    private UUID documentId;
    private UUID roomId;
    private String roomUrl;
    private UUID evaluationId;
    private String evaluationUrl;
}
