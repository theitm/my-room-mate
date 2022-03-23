package motelRoom.dto.valuation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationCreateDto implements Serializable {
    private String Evaluation_id;
    private String rom_id;
    private String used_id;
    private String rate;
    private String comment_rate;
    private String time_rate;

}
