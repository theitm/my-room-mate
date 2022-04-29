package motelRoom.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import motelRoom.entity.addressEntity.DistrictEntity;
import motelRoom.entity.addressEntity.ProvinceEntity;
import motelRoom.entity.addressEntity.WardEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "table_room")
public class RoomEntity {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "room_id", columnDefinition = "CHAR(40)")
    @Type(type = "uuid-char")
    private UUID roomId;
    @Type(type = "uuid-char")
    @Column(name="user_id")
    private UUID userId;
    @Column(name="province_id")
    private int provinceId;
    @Column(name = "district_id")
    private int districtId;
    @Column(name="ward_id")
    private int wardId;
    @Column(name="street")
    private String street;
    @Column(name = "price")
    private float price;
    @Column(name="capacity")
    private float capacity;
    @Column(name = "description_room")
    private String descriptionRoom;
    @Column(name="status_room")
    private int statusRoom;

    /**relationship many room one province**/
    @ManyToOne
    @JoinColumn(name = "province_id",insertable = false,updatable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private ProvinceEntity provinceEntity;

    /**relationship many room one district**/
    @ManyToOne
    @JoinColumn(name = "district_id",insertable = false,updatable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private DistrictEntity districtEntity;

    /**relationship many room one ward**/
    @ManyToOne
    @JoinColumn(name = "ward_id",insertable = false,updatable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private WardEntity wardEntity;

    /**relationship one room many evaluation **/
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id", referencedColumnName = "room_id", insertable=false, updatable=false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<EvaluationEntity> evaluationEntities
            = new ArrayList<>();

    /**relationship many room one user**/
    @ManyToOne
    @JoinColumn(name = "user_id",insertable = false,updatable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private UserEntity userEntity;

    /**relationship one room many evaluation **/
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id", referencedColumnName = "room_id", insertable=false, updatable=false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<DocumentEntity> documentEntities
            = new ArrayList<>();
}