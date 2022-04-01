package motelRoom.dto.address.province;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProvinceDetailDto implements Serializable {
    private Integer id;
    private String name;
    private String code;
}
