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
import java.util.Date;
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
    @GenericGenerator(name = "uuid2",strategy = "uuid2")
    @Column(name = "evaluation_id", columnDefinition = "VARCHAR(40)")
    @Type(type = "uuid-char")
    private UUID evaluationId;
    @Column(name = "room_id")
    @Type(type = "uuid-char")
    private UUID roomId;
    @Column(name = "user_id")
    @Type(type = "uuid-char")
    private UUID userId;
    @Column(name = "rate")
    private Float rate;
    @Column(name = "comment_rate")
    private String commentRate;
    @Column(name = "time_rate")
    private Date timeRate;
}
