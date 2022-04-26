package motelRoom.dto.sharingDetail;

import lombok.*;
import java.io.Serializable;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SharingDetailDetailDto implements Serializable {
    private UUID sharingDetailId;
    private UUID sharingId;
    private UUID userId;
    private String role;;
}