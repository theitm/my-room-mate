package motelRoom.dto.document;
import lombok.*;
import java.util.UUID;
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentCreateDto {
    private UUID room_id;
    private String  url_room;
    private UUID evaluation_id;
    private String  url_evaluation;
}
