package motelRoom.dto.roomSharing;

import lombok.*;
import motelRoom.dto.sharingDetail.SharingDetailCreateDto;


import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RoomSharingCreateDto  {

    private UUID room_id;
    private List<SharingDetailCreateDto> sharingDetailEntities;
}
