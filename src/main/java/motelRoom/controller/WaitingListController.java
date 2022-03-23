package motelRoom.controller;

import motelRoom.dto.waitingList.WaitingListCreateDto;
import motelRoom.dto.waitingList.WaitingListDetailDto;
import motelRoom.service.waitingListService.WaitingListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/WaitingList")
public class WaitingListController {
    @Autowired
    WaitingListServiceImpl service;

    @GetMapping("/getAll")
    public List<WaitingListDetailDto> getAll()
    {
        return service.getAllWaitingList();
    }


    @GetMapping("/{id}")
    public ResponseEntity<WaitingListDetailDto > findById(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.getById(id));
    }

    @PostMapping("/add")
    public WaitingListDetailDto addWaitingList(@RequestBody WaitingListCreateDto createDto)
    {
        //return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.addWaitingList(createDto));
        return service.addWaitingList(createDto);
    }

}
