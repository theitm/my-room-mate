package motelRoom.controller;


import motelRoom.dto.roomSharing.RoomSharingCreateDto;
import motelRoom.dto.roomSharing.RoomSharingDetailDto;
import motelRoom.service.roomSharingService.RoomSharingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/room_sharing")
public class RoomSharingController {

    private final RoomSharingService roomSharingService;

    public RoomSharingController(RoomSharingService roomSharingService) {
        this.roomSharingService = roomSharingService;
    }

    @GetMapping
    public List<RoomSharingDetailDto> getAllRoomSharing() {

        return roomSharingService.getAllRoomSharing();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomSharingDetailDto> findById(@PathVariable UUID sharing_id) {
        return ResponseEntity.ok(roomSharingService.findById(sharing_id));
    }

    @PostMapping
    public ResponseEntity<RoomSharingDetailDto> addRoomSharing(@RequestBody RoomSharingCreateDto roomSharingCreateDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(roomSharingService.createRoomSharing(roomSharingCreateDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomSharingDetailDto> updateRoomSharing(@PathVariable UUID sharing_id, @RequestBody RoomSharingCreateDto roomSharingCreateDto) {
        RoomSharingDetailDto roomSharingDetailDto = roomSharingService.updateRoomSharing(sharing_id, roomSharingCreateDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(roomSharingDetailDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable UUID sharing_id) {
        roomSharingService.deleteById(sharing_id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
