package motelRoom.service.roomSharingService;

import motelRoom.dto.roomSharing.RoomSharingCreateDto;
import motelRoom.dto.roomSharing.RoomSharingDetailDto;
import java.util.List;
import java.util.UUID;

public interface RoomSharingService {
    RoomSharingDetailDto findById(UUID sharingId);
    List<RoomSharingDetailDto> getAllRoomSharing();
    RoomSharingDetailDto updateRoomSharing(UUID sharingId, RoomSharingDetailDto roomSharingDetailDto);
    String deleteById(UUID sharingId);
    String createRoomSharing(RoomSharingCreateDto roomSharingCreateDto);
}