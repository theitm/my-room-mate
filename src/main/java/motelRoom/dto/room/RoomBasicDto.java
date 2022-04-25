package motelRoom.dto.room;

import lombok.Data;
import motelRoom.entity.addressEntity.ProvinceEntity;

import java.io.Serializable;
import java.util.UUID;

@Data
public class RoomBasicDto implements Serializable {
    private UUID roomId;
    private UUID userId;
    private int provinceId;
    private int districtId;
    private int wardId;
    private String street;
    private float price;
    private float capacity;
    private String descriptionRoom;
    private Integer statusRoom;
    private ProvinceEntity provinceEntity;
}
