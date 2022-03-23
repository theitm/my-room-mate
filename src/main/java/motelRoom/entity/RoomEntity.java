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
@Table(name = "room")
public class RoomEntity {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "VARCHAR(40)")
    @Type(type = "uuid-char")
    private UUID room_id;
    private UUID user_id;
    private UUID province_id;
    private UUID district_id;
    private UUID ward_id;
    private String street;
    private float price;
    private float capacity;
    private String description_room;
    private int status_room;


}
