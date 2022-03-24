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
@Table(name = "document")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DocumentEntity {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "VARCHAR(40)")
    @Type(type = "uuid-char")
    private UUID doccument_id;


    @Column(name = "room_id")
    private String room_id;
    @Column(name = "url_room")
    private String url_room;
    @Column(name = "evaluation_id")
    private String evaluation_id;
    @Column(name = "url_evaluation")
    private String url_evaluation;


}
