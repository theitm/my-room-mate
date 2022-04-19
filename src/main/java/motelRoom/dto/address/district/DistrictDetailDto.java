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
    private int districtId;
    private String districtName;
    private String districtPrefix;
    private int provinceId;
    List<WardEntity> wards;
}
