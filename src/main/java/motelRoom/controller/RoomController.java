package motelRoom.controller;

import motelRoom.dto.room.RoomCreateDto;
import motelRoom.dto.room.RoomDetailDto;
import motelRoom.service.roomService.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/room")
public class RoomController {
    private final RoomService roomService;
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    /** Create room **/
    @PostMapping
    public RoomDetailDto createRoom(@RequestBody RoomCreateDto roomCreateDto)
    {
        return roomService.createRoom(roomCreateDto);
    }

    /** Get all room **/
    @GetMapping
    public List<RoomDetailDto> findAll()
    {
        return roomService.findAll();
    }

    /** Get by id **/
    @GetMapping("/{id}")
    public ResponseEntity<RoomDetailDto> findById(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(roomService.findById(id));
    }

    /** Delete room by id **/
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id) {
        roomService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    /** Delete room by user_id **/
    @DeleteMapping("/user/{user_id}")
    public ResponseEntity delete1(@PathVariable UUID user_id){
        roomService.deleteByUserId(user_id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    /** Update room **/
    @PutMapping("/{id}")
    public ResponseEntity<RoomDetailDto> updateRoom(@PathVariable UUID id,
                                                    @RequestBody RoomCreateDto roomCreateDto) {
        RoomDetailDto roomDetailDto = roomService.updateRoom(id, roomCreateDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(roomDetailDto);
    }

    /** Get room by user_id **/
    @GetMapping("user/{user_id}")
    public List<RoomDetailDto> findByUserId(@PathVariable UUID user_id)
    {
        return (roomService.findByUserId(user_id));
    }

}
