package motelRoom.controller;


import motelRoom.dto.room.RoomCreateDto;
import motelRoom.dto.room.RoomDetailDto;
import motelRoom.service.roomService.RoomService;
import motelRoom.service.roomService.RoomServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/room")
public class RoomController {
//    @Autowired
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }
    /** Tạo mới một room **/
    @PostMapping
    public RoomDetailDto createRoom(@RequestBody RoomCreateDto roomCreateDto)
    {
        return roomService.createRoom(roomCreateDto);
    }

    /** Lấy tất cả room **/
    @GetMapping
    public List<RoomDetailDto> findAll()
    {
        return roomService.findAll();
    }
    /** Lấy room theo id **/
    @GetMapping("/{id}")
    public ResponseEntity<RoomDetailDto> findById(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(roomService.findById(id));
    }
    /** Xóa một room **/
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id) {
        roomService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    /** Update một room **/
    @PutMapping("/{id}")
    public ResponseEntity<RoomDetailDto> updateRoom(@PathVariable UUID id,
                                                    @RequestBody RoomCreateDto roomCreateDto) {
        RoomDetailDto roomDetailDto = roomService.updateRoom(id, roomCreateDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(roomDetailDto);

    }


}
