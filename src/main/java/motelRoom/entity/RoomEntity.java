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
    private UUID room_id;
    @Type(type = "uuid-char")
    @Column(name="user_id")
    private UUID user_id;
    @Column(name="province_id")
    private Integer province_id;
    @Column(name = "district_id")
    private Integer district_id;
    @Column(name="ward_id")
    private Integer ward_id;
    @Column(name="street")
    private String street;
    @Column(name = "price")
    private float price;
    @Column(name="capacity")
    private float capacity;
    @Column(name = "description_room")
    private String description_room;
    @Column(name="status_room")
    private Integer status_room;
}