package motelRoom.entity.addressEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

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
         @OneToMany(
                        cascade = CascadeType.ALL,
                         mappedBy = "provinces"
                )
         @EqualsAndHashCode.Exclude
         @ToString.Exclude
         @JsonManagedReference
         @JsonIgnore
         private Collection<DistrictEntity> district
                 = new ArrayList<DistrictEntity>();

    /**relationship one province many ward**/
    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "provinces"
    )
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonManagedReference
    @JsonIgnore
    private Collection<WardEntity> ward
            = new ArrayList<WardEntity>();

}
