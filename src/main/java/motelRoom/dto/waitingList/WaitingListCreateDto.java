package motelRoom.dto.waitingList;

import lombok.Data;

import java.util.UUID;

@Data
public class WaitingListCreateDto {

    private UUID user_id;
    private UUID room_id;
}
