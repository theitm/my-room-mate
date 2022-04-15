package motelRoom.dto.document;

import lombok.*;
import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentDetailDto implements Serializable {
    private UUID documentId;
    private UUID typeId;
    private String typeUrl;

}
