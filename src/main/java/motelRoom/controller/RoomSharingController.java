package motelRoom.controller;


import motelRoom.dto.roomSharing.RoomSharingCreateDto;
import motelRoom.dto.roomSharing.RoomSharingDetailDto;
import motelRoom.dto.sharingDetail.SharingDetailDetailDto;
import motelRoom.entity.RoomSharingEntity;
import motelRoom.service.roomSharingService.RoomSharingService;
import motelRoom.service.sharingDetailService.SharingDetailService;
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

    @GetMapping("/{sharing_id}")
    public ResponseEntity<RoomSharingDetailDto> findById(@PathVariable UUID sharing_id) {
        ResponseEntity responseEntity = ResponseEntity.ok(roomSharingService.findById(sharing_id));
        return responseEntity;
    }

    @PostMapping
    public ResponseEntity<RoomSharingDetailDto> createRoomSharing(@RequestBody RoomSharingCreateDto roomSharingCreateDto) {
        ResponseEntity responseEntity = ResponseEntity.status(HttpStatus.ACCEPTED).body(roomSharingService.createRoomSharing(roomSharingCreateDto));
        return responseEntity;
    }

    @PutMapping("/{sharing_id}")
    public ResponseEntity<RoomSharingDetailDto> updateRoomSharing(@PathVariable UUID sharing_id, @RequestBody RoomSharingCreateDto roomSharingCreateDto) {
        RoomSharingDetailDto roomSharingDetailDto = roomSharingService.updateRoomSharing(sharing_id, roomSharingCreateDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(roomSharingDetailDto);
    }

    @DeleteMapping("/{sharing_id}")
    public ResponseEntity deleteById(@PathVariable UUID sharing_id) {
        roomSharingService.deleteById(sharing_id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
