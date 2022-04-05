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
    private Integer ward_id;
    @Column(name="name_ward")
    private String name_ward;
    @Column(name="prefix_ward")
    private String prefix_ward;
    @Column(name="province_id")
    private String province_id;
    @Column(name = "district_id")
    private Integer district_id;

    /**relationship many ward one district**/
    @ManyToOne
    @JoinColumn(name = "district_id",insertable = false,updatable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private DistrictEntity districts;
}
