package motelRoom.dto.address.district;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DistrictDetailDto implements Serializable {
    private Integer id;
    private String name;
    private String prefix;
    private Integer province_id;
}
