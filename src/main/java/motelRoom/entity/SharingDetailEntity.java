package motelRoom.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "sharing_detail")
public class SharingDetailEntity {

    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "sharing_detail_id", columnDefinition = "CHAR(40)")
    @Type(type = "uuid-char")
    private UUID sharing_detail_id;

    @Column( name = "sharing_id")
    @Type( type = "uuid-char")
    private UUID sharing_id;

    @Column( name = "user_id")
    @Type( type = "uuid-char")
    private UUID user_id;

    @Column(name = "roles")
    private String role;;

    @ManyToOne
    @JoinColumn(name = "sharing_id", insertable = false, updatable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private RoomSharingEntity roomSharing;
}