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
    private UUID roomId;
    private UUID userId;
    private Float rate;
    private String commentRate;
    private Date timeRate;
}
