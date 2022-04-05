package motelRoom.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import javax.persistence.*;
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
}