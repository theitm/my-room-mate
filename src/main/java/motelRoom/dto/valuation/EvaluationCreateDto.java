package motelRoom.dto.valuation;

import lombok.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationCreateDto implements Serializable {

    //Create thi khong can evaluationId
    //private UUID evaluationId;
    private UUID roomId;
    private UUID userId;
    private Float rate;
    private String commentRate;
    private Date timeRate;

}
