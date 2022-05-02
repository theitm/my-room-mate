package motelRoom.dto.evaluation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import motelRoom.entity.RoomEntity;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationDetailDto implements Serializable {
    private UUID evaluationId;
    private UUID roomId;
    private UUID userId;
    private Float rate;
    private String commentRate;
    private Date timeRate;
}
