package motelRoom.dto.room;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;
@Data
public class RoomCreateDto implements Serializable {
    private UUID userId;
    private Integer provinceId;
    private Integer districtId;
    private Integer wardId;
    private String street;
    private float price;
    private float capacity;
    private String descriptionRoom;
    private Integer statusRoom;
}
