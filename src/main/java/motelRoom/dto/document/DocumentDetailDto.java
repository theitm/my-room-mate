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
    private UUID doccument_id;
    private UUID room_id;
    private String url_room;
    private UUID evaluation_id;
    private String url_evaluation;
}
