package motelRoom.controller;


import motelRoom.dto.room.RoomDetailDto;
import motelRoom.service.roomService.RoomServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/room")
public class RoomController {
//    @Autowired
    public final RoomServiceImpl service;

    public RoomController(RoomServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/getAll")
    public List<RoomDetailDto> getAll()
    {
        return service.getAllRoom();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomDetailDto> findById(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.getById(id));
    }




}
