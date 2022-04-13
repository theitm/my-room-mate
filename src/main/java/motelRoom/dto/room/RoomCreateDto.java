package motelRoom.dto.room;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;
@Data
public class RoomCreateDto implements Serializable {
    private UUID userId;
    private int provinceId;
    private int districtId;
    private int wardId;
    private String street;
    private float price;
    private float capacity;
    private String descriptionRoom;
    private Integer statusRoom;
}
