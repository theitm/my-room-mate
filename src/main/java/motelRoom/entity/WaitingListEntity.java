package motelRoom.entity;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table(name = "waiting_list")
public class WaitingListEntity {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "VARCHAR(40)")
    @Type(type = "uuid-char")
    private UUID waiting_list_id;
    @Type(type = "uuid-char")
    private UUID user_id;
    @Type(type = "uuid-char")
    private UUID room_id;
}
