package motelRoom.dto.valuation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationCreateDto implements Serializable {
    private UUID evaluation_id;
    private UUID room_id;
    private UUID user_id;
    private String rate;
    private String comment_rate;
    private String time_rate;

}
