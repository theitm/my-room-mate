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
    private Integer wardId;
    private String wardName;
    private String wardPrefix;
    private Integer provinceId;
    private Integer districtId;
}
