package motelRoom.entity;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.util.UUID;
@Entity
@Table(name = "document")
@Data
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DocumentEntity {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "doccument_id", columnDefinition = "CHAR(40)")
    @Type(type = "uuid-char")
    private UUID doccument_id;
    @Type(type = "uuid-char")
    @Column(name = "room_id")
    private UUID room_id;
    @Column(name = "url_room")
    private String url_room;
    @Type(type = "uuid-char")
    @Column(name = "evaluation_id")
    private UUID evaluation_id;
    @Column(name = "url_evaluation")
    private String url_evaluation;
}
