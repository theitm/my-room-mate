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
    @Column(name="ward_id")
    private Integer wardId;
    @Column(name="name_ward")
    private String wardName;
    @Column(name="prefix_ward")
    private String wardPrefix;
    @Column(name="province_id")
    private String provinceId;
    @Column(name = "district_id")
    private Integer districtId;

    /**relationship many ward one district**/
    @ManyToOne
    @JoinColumn(name = "district_id",insertable = false,updatable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private DistrictEntity districts;
}
