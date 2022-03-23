package motelRoom.dto.room;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class RoomDetailDto implements Serializable {
    private UUID room_id;
    private UUID user_id;
    private UUID province_id;
    private UUID district_id;
    private UUID ward_id;
    private String street;
    private float price;
    private float capacity;
    private String description_room;
    private int status_room;
}
