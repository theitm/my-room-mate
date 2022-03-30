package motelRoom.entity.addressEntity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
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
    @Column(name="district_id")
    private Integer district_id;
    @Column(name="name_district")
    private String name_district;
    @Column(name="prefix_district")
    private String prefix_district;
    @Column(name="province_id")
    private String province_id;

    /**relationship many district one province**/
    @ManyToOne
    @JoinColumn(name = "province_id",insertable = false,updatable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private ProvinceEntity provinceEntity;

    /**relationship one district many ward **/
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "district_id", referencedColumnName = "district_id", insertable=false, updatable=false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<WardEntity> wards
            = new ArrayList<WardEntity>();
}
