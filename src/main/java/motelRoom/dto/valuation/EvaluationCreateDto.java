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

    //Create thi khong can evaluation_id
    //private UUID evaluation_id;
    private UUID room_id;
    private UUID user_id;
    private Float rate;
    private String comment_rate;
    private Date time_rate;

}
