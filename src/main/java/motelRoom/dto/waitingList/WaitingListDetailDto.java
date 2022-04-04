package motelRoom.dto.waitingList;

import java.io.Serializable;
import java.util.UUID;

import lombok.Data;

@Data
public class WaitingListDetailDto implements Serializable {
    private UUID id;
    private UUID userId;
    private UUID roomId;

}
