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
    private Integer districtId;
    private String districtName;
    private String districtPrefix;
    private Integer provinceId;
    List<WardEntity> wards;
}
