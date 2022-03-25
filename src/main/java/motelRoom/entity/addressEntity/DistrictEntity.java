package motelRoom.entity.addressEntity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="district")
public class DistrictEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="_name")
    private String name;
    @Column(name="_prefix")
    private String prefix;
    @Column(name="_province_id")
    private String province_id;

    /**relationship many district one province**/
    @ManyToOne
    @JoinColumn(name = "_province_id",insertable = false,updatable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private ProvinceEntity provinceEntity;

    /**relationship one district many ward **/
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "_district_id", referencedColumnName = "id", insertable=false, updatable=false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<WardEntity> wardEntities
            = new ArrayList<WardEntity>();


}
