package motelRoom.dto.roomSharing;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import motelRoom.dto.sharingDetail.SharingDetailDetailDto;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RoomSharingDetailDto implements Serializable {
    private UUID sharingId;
    private UUID roomId;
    private List<SharingDetailDetailDto> sharingDetails;
}