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
    private int wardId;
    private String wardName;
    private String wardPrefix;
    private int provinceId;
    private int districtId;
}
