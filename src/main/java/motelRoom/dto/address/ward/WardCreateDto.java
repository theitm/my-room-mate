package motelRoom.dto.address.ward;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WardCreateDto implements Serializable {
    private Integer id;
    private String name;
    private String prefix;
    private Integer province_id;
    private Integer district_id;
}
