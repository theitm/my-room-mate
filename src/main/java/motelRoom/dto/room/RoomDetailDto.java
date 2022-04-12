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
    private UUID room_id;
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
