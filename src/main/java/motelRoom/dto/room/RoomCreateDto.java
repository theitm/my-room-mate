package motelRoom.dto.room;

import java.io.Serializable;
import java.util.UUID;

public class RoomCreateDto implements Serializable {
    private UUID room_id;
    private UUID user_id;
    private String province_id;
    private String district_id;
    private String ward_id;
    private String street;
    private float price;
    private float capacity;
    private String description_room;
    private Integer status_room;
}
