package motelRoom.entity.addressEntity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
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
    @Column(name = "id")
    private Integer id;
    @Column(name = "_name")
    private String name;
    @Column(name = "_code")
    private String code;

    /**relationship one province many district**/
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "_province_id", referencedColumnName = "id", insertable=false, updatable=false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<DistrictEntity> districtEntities
            = new ArrayList<DistrictEntity>();

}
