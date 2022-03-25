package motelRoom.entity.addressEntity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "ward")
public class WardEntity {
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
    @Column(name = "_district_id")
    private Integer district_id;

    /**relationship district with ward**/
    @ManyToOne
    @JoinColumn(name = "_district_id",insertable = false,updatable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private DistrictEntity districtEntity;
}
