package motelRoom.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="evaluation")
public class EvaluationEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    private String evaluation_id;
    private String rom_id;
    private String used_id;
    private String rate;
    private String comment_rate;
    private String time_rate;





}
