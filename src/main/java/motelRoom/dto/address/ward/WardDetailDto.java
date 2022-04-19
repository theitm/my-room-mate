package motelRoom.dto.address.ward;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WardDetailDto implements Serializable {
    private Integer ward_id;
    private String name_ward;
    private String prefix_ward;
    private Integer province_id;
    private Integer district_id;
}
