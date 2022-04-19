package motelRoom.dto.room;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;
@Data
public class RoomCreateDto implements Serializable {
    private UUID user_id;
    private Integer province_id;
    private Integer district_id;
    private Integer ward_id;
    private String street;
    private float price;
    private float capacity;
    private String description_room;
    private Integer status_room;
}
