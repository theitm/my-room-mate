package motelRoom.dto.sharingDetail;

import lombok.*;
import java.io.Serializable;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SharingDetailCreateDto implements Serializable {
    private UUID sharingId;
    private UUID userId;
    private String role;;
}