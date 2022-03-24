package motelRoom.service.roomService;

import motelRoom.dto.room.RoomCreateDto;
import motelRoom.dto.room.RoomDetailDto;
import motelRoom.entity.RoomEntity;

import java.util.List;
import java.util.UUID;

public interface RoomService {
    RoomDetailDto createRoom(RoomCreateDto roomCreateDto);
    RoomDetailDto findById(UUID id);
    RoomDetailDto updateRoom(UUID id, RoomCreateDto roomCreateDto);


    void deleteById(UUID id);

    List<RoomDetailDto> findAll();


}
