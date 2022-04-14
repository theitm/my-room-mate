package motelRoom.mapper;
import motelRoom.dto.waitingList.WaitingListCreateDto;
import motelRoom.dto.waitingList.WaitingListDetailDto;
import motelRoom.entity.WaitingListEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface WaitingListMapper {
    /**.....map Waiting List CreateDto to Waiting List Entity...........**/
    WaitingListEntity fromDtoCreateEntity(WaitingListCreateDto waitingListCreateDto);
    /**.....map Waiting List Entity to Waiting List DetailDto...........**/
    WaitingListDetailDto fromEntityToDetailDto(WaitingListEntity waitingListEntity);
    /**.....map List Entity to List Detail Dto...........**/
    List<WaitingListDetailDto> fromEntitiesToDto(List<WaitingListEntity> waitingListEntities);
}
