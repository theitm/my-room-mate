package motelRoom.dto.document;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentCreateDto {


    private String room_id;
    private String  url_room;
    private String evaluation_id;
    private String  url_evaluation;
}
