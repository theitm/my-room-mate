package motelRoom.controller;

import motelRoom.dto.roomSharing.RoomSharingCreateDto;
import motelRoom.dto.roomSharing.RoomSharingDetailDto;
import motelRoom.dto.sharingDetail.SharingDetailCreateDto;
import motelRoom.dto.sharingDetail.SharingDetailDetailDto;
import motelRoom.service.sharingDetailService.SharingDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/sharing_detail")

public class SharingDetailController {

    private final SharingDetailService sharingDetailService;

    public SharingDetailController(SharingDetailService sharingDetailService) {
        this.sharingDetailService = sharingDetailService;
    }

    /** Get all sharing_detail **/
    @GetMapping
    public List<SharingDetailDetailDto> findAll(){
        return sharingDetailService.findAll();
    }

    /** Get sharing_detail by sharing_detail_id **/
    @GetMapping("/{sharing_detail_id}")
    public ResponseEntity<SharingDetailDetailDto> findById(@PathVariable UUID sharing_detail_id) {
        return ResponseEntity.ok(sharingDetailService.findById(sharing_detail_id));
    }

    /** Create sharing_detail **/
    @PostMapping
    public ResponseEntity<SharingDetailDetailDto> addRoomSharing(@RequestBody SharingDetailCreateDto sharingDetailCreateDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(sharingDetailService.createSharingDetail(sharingDetailCreateDto));
    }

    /** Update sharing_detail **/
    @PutMapping("/{sharing_detail_id}")
    public ResponseEntity<SharingDetailDetailDto> update(@PathVariable UUID sharing_detail_id,
                                                         @RequestBody SharingDetailDetailDto sharingDetailDetailDto) {
        SharingDetailDetailDto sharingDetailDetailDtoUpdate = sharingDetailService.updateSharingDetail(sharing_detail_id, sharingDetailDetailDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(sharingDetailDetailDtoUpdate);
    }

    /** Delete sharing_detail by sharing_detail_id **/
    @DeleteMapping("/{sharing_detail_id}")
    public ResponseEntity deleteById(@PathVariable UUID sharing_detail_id) {
        sharingDetailService.deleteById(sharing_detail_id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    /** Get sharing_detail by sharing_id**/
    @GetMapping("sharing_id/{sharing_id}")
    public List<SharingDetailDetailDto> findSDBySharingId(@PathVariable UUID sharing_id)
    {
        return (sharingDetailService.findSDBySharingId(sharing_id));
    }
}