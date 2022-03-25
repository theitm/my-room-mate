package motelRoom.dto.address.province;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import motelRoom.dto.address.district.DistrictCreateDto;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProvinceDetailDto implements Serializable {
    private Integer id;
    private String name;
    private String code;
    private List<DistrictCreateDto> districtEntities;
}
