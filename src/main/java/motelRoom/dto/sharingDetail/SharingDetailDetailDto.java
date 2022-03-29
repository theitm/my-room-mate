package motelRoom.dto.sharingDetail;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SharingDetailDetailDto implements Serializable {
    private UUID sharing_detail_id;
    private UUID sharing_id;
    private UUID user_id;
    private String role;;

}
