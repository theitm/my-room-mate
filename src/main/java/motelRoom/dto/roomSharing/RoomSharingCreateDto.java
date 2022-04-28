package motelRoom.dto.roomSharing;

import lombok.*;
import motelRoom.dto.sharingDetail.SharingDetailCreateDto;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RoomSharingCreateDto implements Serializable {
    private UUID roomId;
    private List<SharingDetailCreateDto> sharingDetails;
}