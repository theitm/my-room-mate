package motelRoom.dto.document;


import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

@Data
public class DocumentDetailDto implements Serializable {



    private UUID doccument_id;
    private String room_id;
    private String url_room;
    private String evaluation_id;
    private String url_evaluation;

}
