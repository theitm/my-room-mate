package motelRoom.controller;

import motelRoom.dto.sharingDetail.SharingDetailCreateDto;
import motelRoom.dto.sharingDetail.SharingDetailDetailDto;
import motelRoom.service.sharingDetailService.SharingDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/sharing_detail")

public class SharingDetailController {

    private final SharingDetailService sharingDetailService;

    public SharingDetailController(SharingDetailService sharingDetailService) {
        this.sharingDetailService = sharingDetailService;
    }


    @GetMapping
    public List<SharingDetailDetailDto> findAll(){
        return sharingDetailService.findAll();
    }

    @GetMapping("/{sharing_detail_id}")
    public ResponseEntity<SharingDetailDetailDto> findById(@PathVariable UUID sharing_detail_id) {
        return ResponseEntity.ok(sharingDetailService.findById(sharing_detail_id));
    }

    @PostMapping
    public ResponseEntity<SharingDetailDetailDto> addRoomSharing(@RequestBody SharingDetailCreateDto sharingDetailCreateDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(sharingDetailService.createSharingDetail(sharingDetailCreateDto));
    }

    @PutMapping("/{sharing_detail_id}")
    public ResponseEntity<SharingDetailDetailDto> updateSharingDetail(@PathVariable UUID sharing_detail_id, @RequestBody SharingDetailCreateDto sharingDetailCreateDto) {
        SharingDetailDetailDto sharingDetailDetailDto = sharingDetailService.updateSharingDetail(sharing_detail_id, sharingDetailCreateDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(sharingDetailDetailDto);
    }

    @DeleteMapping("/{sharing_detail_id}")
    public ResponseEntity deleteById(@PathVariable UUID sharing_detail_id) {
        sharingDetailService.deleteById(sharing_detail_id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
