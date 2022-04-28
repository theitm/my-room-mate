package motelRoom.controller;

import motelRoom.dto.sharingDetail.SharingDetailCreateDto;
import motelRoom.dto.sharingDetail.SharingDetailDetailDto;
import motelRoom.service.sharingDetailService.SharingDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/sharingdetail")
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
    @GetMapping("/{sharingDetailId}")
    public ResponseEntity<SharingDetailDetailDto> findById(@PathVariable UUID sharingDetailId) {
        return ResponseEntity.ok(sharingDetailService.findById(sharingDetailId));
    }

    /** Create sharing_detail **/
    @PostMapping
    public ResponseEntity<SharingDetailDetailDto> createSharingDetail(@Valid @RequestBody SharingDetailCreateDto sharingDetailCreateDto) {
        ResponseEntity responseEntity = ResponseEntity.status(HttpStatus.ACCEPTED).body(sharingDetailService.createSharingDetail(sharingDetailCreateDto));
        return responseEntity;
    }

    /** Update sharing_detail **/
    @PutMapping("/{sharingDetailId}")
    public ResponseEntity<SharingDetailDetailDto> update(@PathVariable UUID sharingDetailId,
                                                         @Valid @RequestBody SharingDetailDetailDto sharingDetailDetailDto) {
        SharingDetailDetailDto sharingDetailDetailDtoUpdate = sharingDetailService.updateSharingDetail(sharingDetailId, sharingDetailDetailDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(sharingDetailDetailDtoUpdate);
    }

    /** Delete sharing_detail by sharing_detail_id **/
    @DeleteMapping("/{sharingDetailId}")
    public ResponseEntity deleteById(@PathVariable UUID sharingDetailId) {
        sharingDetailService.deleteById(sharingDetailId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}