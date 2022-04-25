package motelRoom.dto.waitingList;

import lombok.Data;
import motelRoom.entity.RoomEntity;

import java.io.Serializable;
import java.util.UUID;

@Data
public class WaitingListBasicDto implements Serializable {
    private UUID id;
    private UUID userId;
    private UUID roomId;
    private RoomEntity roomEntity;
}
