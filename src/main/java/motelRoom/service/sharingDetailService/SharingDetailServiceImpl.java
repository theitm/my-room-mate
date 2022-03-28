package motelRoom.service.sharingDetailService;

import motelRoom.dto.sharingDetail.SharingDetailCreateDto;
import motelRoom.dto.sharingDetail.SharingDetailDetailDto;
import motelRoom.entity.SharingDetailEntity;
import motelRoom.mapper.SharingDetailMapper;
import motelRoom.repository.SharingDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class SharingDetailServiceImpl implements SharingDetailService{

    @Autowired
    private final SharingDetailRepository sharingDetailRepository;
    @Autowired
    private final SharingDetailMapper sharingDetailMapper;

    public SharingDetailServiceImpl(SharingDetailRepository sharingDetailRepository,
                                    SharingDetailMapper sharingDetailMapper) {
        this.sharingDetailRepository = sharingDetailRepository;
        this.sharingDetailMapper = sharingDetailMapper;
    }

    @Override
    public SharingDetailDetailDto createSharingDetail(SharingDetailCreateDto sharingDetailCreateDto) {
        SharingDetailEntity sharingDetailEntity = sharingDetailMapper.fromSharingDetailCreateDto(sharingDetailCreateDto);
        SharingDetailEntity sharingDetailEntityCreate = sharingDetailRepository.save(sharingDetailEntity);
        SharingDetailDetailDto sharingDetailDetailDto = null;
        if(sharingDetailEntityCreate != null){
            sharingDetailDetailDto = sharingDetailMapper.fromEntityToDto(sharingDetailEntityCreate);
        }
        return sharingDetailDetailDto;
    }

    @Override
    public SharingDetailDetailDto findById(UUID sharing_detail_id) {
        SharingDetailDetailDto sharingDetailDetailDto = sharingDetailMapper.fromEntityToDto(sharingDetailRepository.getById(sharing_detail_id));
        return sharingDetailDetailDto;
    }

    @Override
    public List<SharingDetailDetailDto> findAll() {
        return sharingDetailMapper.fromListEntityToDto(sharingDetailRepository.findAll());
    }

    @Override
    public SharingDetailDetailDto updateSharingDetail(UUID sharing_detail_id,SharingDetailCreateDto sharingDetailCreateDto) {
        SharingDetailEntity sharingDetailEntity = sharingDetailMapper.fromSharingDetailCreateDto(sharingDetailCreateDto);
        sharingDetailEntity.setSharing_detail_id(sharing_detail_id);
        sharingDetailRepository.save(sharingDetailEntity);
        SharingDetailDetailDto sharingDetailDetailDto = sharingDetailMapper.fromEntityToDto(sharingDetailEntity);
        return sharingDetailDetailDto;
    }

    @Override
    public void deleteById(UUID sharing_detail_id) {
        sharingDetailRepository.deleteById(sharing_detail_id);
    }
}
