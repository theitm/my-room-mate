package motelRoom.entity;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "room_sharing")
@Data
public class RoomSharingEntity {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "sharing_id", columnDefinition = "CHAR(40)")
    @Type(type = "uuid-char")
    private UUID sharingId;

    @Column( name = "room_id", nullable = false)
    @Type( type = "uuid-char")
    private UUID roomId;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @Cascade(value= {org.hibernate.annotations.CascadeType.DELETE})
    @JoinColumn(name = "sharing_id", referencedColumnName = "sharing_id", insertable=false, updatable=false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<SharingDetailEntity> sharingDetails
            =new ArrayList<SharingDetailEntity>();
}