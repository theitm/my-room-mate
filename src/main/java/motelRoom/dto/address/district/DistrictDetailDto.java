package motelRoom.dto.address.district;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import motelRoom.entity.addressEntity.WardEntity;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DistrictDetailDto implements Serializable {
    private Integer district_id;
    private String name_district;
    private String prefix_district;
    private Integer province_id;
    List<WardEntity> wards;
}
