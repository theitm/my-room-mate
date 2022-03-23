package motelRoom.mapper;

import motelRoom.dto.room.RoomDetailDto;
import motelRoom.entity.RoomEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface RoomMapper {
    RoomDetailDto fromEntityToDetailDto(RoomEntity roomEntity);
    List<RoomDetailDto> fromEntitiesToDto(List<RoomEntity> roomEntities);
}
