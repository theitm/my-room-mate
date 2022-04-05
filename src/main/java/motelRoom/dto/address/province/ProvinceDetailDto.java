package motelRoom.dto.address.province;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import motelRoom.entity.addressEntity.DistrictEntity;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProvinceDetailDto implements Serializable {
    private Integer province_id;
    private String name_province;
    private String code_province;
    List<DistrictEntity> districts;
}
