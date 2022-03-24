package motelRoom.mapper;

import motelRoom.dto.room.RoomCreateDto;
import motelRoom.dto.room.RoomDetailDto;
import motelRoom.entity.RoomEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface RoomMapper {
    RoomEntity fromRoomCreateDto(RoomCreateDto roomCreateDto);
    RoomDetailDto fromEntityToDetailDto(RoomEntity roomEntity);
    List<RoomDetailDto> fromEntityToDto(List<RoomEntity> roomEntities);
}
