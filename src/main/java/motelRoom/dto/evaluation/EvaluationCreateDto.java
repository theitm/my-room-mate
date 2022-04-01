package motelRoom.dto.evaluation;


import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationCreateDto implements Serializable {
    private UUID room_id;
    private UUID user_id;
    private Float rate;
    private String comment_rate;
    private Date time_rate;

}
