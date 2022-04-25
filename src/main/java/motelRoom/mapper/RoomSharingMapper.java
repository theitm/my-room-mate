package motelRoom.mapper;

import motelRoom.dto.roomSharing.RoomSharingCreateDto;
import motelRoom.dto.roomSharing.RoomSharingDetailDto;
import motelRoom.entity.RoomSharingEntity;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper
public interface RoomSharingMapper {
    RoomSharingEntity fromRoomSharingCreateDto(RoomSharingCreateDto roomSharingCreateDto);
    RoomSharingDetailDto fromEntityToDto(RoomSharingEntity roomSharingEntity);
    List<RoomSharingDetailDto> fromListEntitiesToDtos (List<RoomSharingEntity> roomSharingEntities);
    RoomSharingEntity fromRoomSharingCreateDto(RoomSharingDetailDto roomSharingDetailDto);

}