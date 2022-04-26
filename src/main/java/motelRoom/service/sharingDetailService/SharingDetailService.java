package motelRoom.service.sharingDetailService;

import motelRoom.dto.sharingDetail.SharingDetailCreateDto;
import motelRoom.dto.sharingDetail.SharingDetailDetailDto;
import java.util.List;
import java.util.UUID;

public interface SharingDetailService {
    String createSharingDetail(SharingDetailCreateDto sharingDetailCreateDto);
    SharingDetailDetailDto findById(UUID sharingDetailId);
    List<SharingDetailDetailDto> findAll();
    SharingDetailDetailDto updateSharingDetail(UUID sharingDetailId, SharingDetailDetailDto sharingDetailDetailDto);
    String deleteById(UUID sharingDetailId);
}