package motelRoom.dto.room;

import lombok.Data;
import motelRoom.entity.DocumentEntity;
import motelRoom.entity.EvaluationEntity;
import motelRoom.entity.UserEntity;
import motelRoom.entity.addressEntity.ProvinceEntity;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
public class RoomDetailDto implements Serializable {
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
}
