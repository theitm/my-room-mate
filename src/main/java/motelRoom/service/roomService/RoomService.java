package motelRoom.service.roomService;

import motelRoom.dto.room.RoomCreateDto;
import motelRoom.dto.room.RoomDetailDto;


import java.util.List;
import java.util.UUID;

public interface RoomService {
    RoomDetailDto findById(UUID id);
    List<RoomDetailDto> findByUserId(UUID user_id);
    RoomDetailDto updateRoom(UUID id, RoomCreateDto roomCreateDto);
    void deleteById(UUID id);
    List<RoomDetailDto> findAll();
    RoomDetailDto createRoom(RoomCreateDto roomCreateDto);
    void deleteByUserId(UUID user_id);
}