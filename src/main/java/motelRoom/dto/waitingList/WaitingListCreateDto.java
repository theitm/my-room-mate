package motelRoom.dto.waitingList;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class WaitingListCreateDto {
    private UUID userId;
    private UUID roomId;
}
