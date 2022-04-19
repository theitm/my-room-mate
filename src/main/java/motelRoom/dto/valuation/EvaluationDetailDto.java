package motelRoom.dto.valuation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationDetailDto implements Serializable {

    private UUID evaluation_id;
    private UUID room_id;
    private UUID user_id;
    private Float rate;
    private String comment_rate;
    private Date time_rate;

}