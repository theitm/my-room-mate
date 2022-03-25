package motelRoom.dto.address.district;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import motelRoom.dto.address.ward.WardCreateDto;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DistrictDetailDto implements Serializable {
    private Integer id;
    private String name;
    private String prefix;
    private Integer province_id;
    private List<WardCreateDto> wardEntities;
}
