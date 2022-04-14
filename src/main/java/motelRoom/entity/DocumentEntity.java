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
@AllArgsConstructor
@NoArgsConstructor
public class DocumentEntity {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "doccument_id", columnDefinition = "CHAR(40)")
    @Type(type = "uuid-char")
    private UUID documentId;
    @Type(type = "uuid-char")
    @Column(name = "type_id")
    private UUID typeId;
    @Column(name = "type_url")
    private String typeUrl;
}
