package motelRoom.entity.addressEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import motelRoom.entity.DocumentEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "province")
public class ProvinceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "province_id")
    private int provinceId;
    @Column(name = "name_province")
    private String provinceName;
    @Column(name = "code_province")
    private String provinceCode;

    /**relationship one province many district**/
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "province_id", referencedColumnName = "province_id", insertable=false, updatable=false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<DistrictEntity> districts
            = new ArrayList<DistrictEntity>();
}
