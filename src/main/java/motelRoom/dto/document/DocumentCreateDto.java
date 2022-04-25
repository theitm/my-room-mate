package motelRoom.dto.document;
import lombok.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentCreateDto {
    private UUID parentId;
    private int parentType;
    private String nameUrl;
    private int typeUrl;
}
