package motelRoom.service.sharingDetailService;

import motelRoom.dto.sharingDetail.SharingDetailCreateDto;
import motelRoom.dto.sharingDetail.SharingDetailDetailDto;

import java.util.List;
import java.util.UUID;

public interface SharingDetailService {

    SharingDetailDetailDto createSharingDetail(SharingDetailCreateDto sharingDetailCreateDto);
    SharingDetailDetailDto findById(UUID sharing_detail_id);
    List<SharingDetailDetailDto> findAll();
    SharingDetailDetailDto updateSharingDetail(UUID sharing_detail_id, SharingDetailDetailDto sharingDetailDetailDto);
    String deleteById(UUID sharing_detail_id);
    List<SharingDetailDetailDto> findSDBySharingId(UUID sharing_id);
}
