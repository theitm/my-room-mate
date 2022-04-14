package motelRoom.dto.document;
import lombok.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentCreateDto {
    private UUID typeId;
    private String typeUrl;
}
