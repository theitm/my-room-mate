package motelRoom.dto.sharingDetail;

import lombok.*;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SharingDetailCreateDto {
    private UUID sharing_id;
    private UUID user_id;
    private Enum role;;

}
