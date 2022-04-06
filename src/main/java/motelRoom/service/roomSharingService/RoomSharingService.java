package motelRoom.service.roomSharingService;

import motelRoom.dto.roomSharing.RoomSharingCreateDto;
import motelRoom.dto.roomSharing.RoomSharingDetailDto;

import java.util.List;
import java.util.UUID;

public interface RoomSharingService {

    RoomSharingDetailDto findById(UUID sharing_id);
    List<RoomSharingDetailDto> getAllRoomSharing();
    RoomSharingDetailDto updateRoomSharing(UUID sharing_id, RoomSharingDetailDto roomSharingDetailDto);
//    void updateRoomSharing(UUID sharing_id, RoomSharingDetailDto roomSharingDetailDto);

    String deleteById(UUID sharing_id);
    String createRoomSharing(RoomSharingCreateDto roomSharingCreateDto);
}
