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
    private int provinceId;
    private String provinceName;
    private String provinceCode;
    List<DistrictEntity> districts;
}
