package motelRoom.controller;

import motelRoom.dto.roomSharing.RoomSharingCreateDto;
import motelRoom.dto.roomSharing.RoomSharingDetailDto;
import motelRoom.service.roomSharingService.RoomSharingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/roomsharing")
public class RoomSharingController {
    private final RoomSharingService roomSharingService;
    public RoomSharingController(RoomSharingService roomSharingService) {
        this.roomSharingService = roomSharingService;
    }

    /** Get all room_sharing **/
    @GetMapping
    public List<RoomSharingDetailDto> getAllRoomSharing() {
        return roomSharingService.getAllRoomSharing();
    }

    /** Get room_sharing by sharing_id **/
    @GetMapping("/{sharingId}")
    public ResponseEntity<RoomSharingDetailDto> findById(@PathVariable UUID sharingId) {
        ResponseEntity responseEntity = ResponseEntity.ok(roomSharingService.findById(sharingId));
        return responseEntity;
    }

    /** Create room_sharing **/
    @PostMapping
    public ResponseEntity<RoomSharingDetailDto> createRoomSharing(@Valid @RequestBody
                                                                              RoomSharingCreateDto roomSharingCreateDto)
    {
        ResponseEntity responseEntity = ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(roomSharingService.createRoomSharing(roomSharingCreateDto));
        return responseEntity;
    }

    /** Update room_sharing by sharing_id**/
    @PutMapping("/{sharingId}")
    public ResponseEntity<RoomSharingDetailDto> update(@PathVariable UUID sharingId,
                                                       @Valid @RequestBody RoomSharingDetailDto roomSharingDetailDto) {
        RoomSharingDetailDto roomSharingDetailDtoUpdate = roomSharingService.updateRoomSharing(sharingId, roomSharingDetailDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(roomSharingDetailDtoUpdate);
    }

    /** Delete room_sharing by sharing_id **/
    @DeleteMapping("/{sharingId}")
    public ResponseEntity deleteById(@PathVariable UUID sharingId) {
        roomSharingService.deleteById(sharingId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}