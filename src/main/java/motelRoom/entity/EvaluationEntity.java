package motelRoom.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.lang.model.element.Name;
import javax.persistence.*;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="evaluation")
public class EvaluationEntity {
    @Id
    @GeneratedValue (generator = "uuid2",strategy = GenerationType.IDENTITY)
    @GenericGenerator(name ="uuid2",strategy = "uuid2")
    @Column(name = "evaluation_id", columnDefinition = "VARCHAR(36)")

    @Type(type = "uuid-char")
    private UUID evaluation_id;

    @Column(name="room_id")
    @Type(type = "uuid-char")
    private UUID room_id;

    @Column(name="user_id")
    @Type(type = "uuid-char")
    private UUID user_id;

    @Column(name = "rate")
    private Float rate;

    @Column(name="comment_rate")
    private String comment_rate;

    @Column(name = "time_rate")
    private Date time_rate;

    public void setId(UUID id) {
    }
}
