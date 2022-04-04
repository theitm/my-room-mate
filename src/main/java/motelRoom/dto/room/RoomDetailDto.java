package motelRoom.dto.room;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RoomDetailDto implements Serializable {
    private UUID roomId;
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
