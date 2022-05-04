package motelRoom.dto.waitingList;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Data;
import motelRoom.entity.RoomEntity;

@Data
public class WaitingListDetailDto implements Serializable {
    private UUID id;
    private UUID userId;
    private UUID roomId;
    private RoomEntity roomEntity;
    private LocalDateTime dateTime;
}
