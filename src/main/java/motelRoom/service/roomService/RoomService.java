package motelRoom.service.roomService;

import motelRoom.dto.room.RoomDetailDto;

import java.util.List;
import java.util.UUID;

public interface RoomService {
    List<RoomDetailDto> getAllRoom();
    RoomDetailDto getById(UUID id);
}
