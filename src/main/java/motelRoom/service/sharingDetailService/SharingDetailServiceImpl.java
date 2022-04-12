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
    public SharingDetailDetailDto findById(UUID sharingDetailId) {
        SharingDetailDetailDto sharingDetailDetailDto = sharingDetailMapper.fromEntityToDto(sharingDetailRepository.getById(sharingDetailId));
        return sharingDetailDetailDto;
    }

    @Override
    public List<SharingDetailDetailDto> findAll() {
        return sharingDetailMapper.fromListEntityToDto(sharingDetailRepository.findAll());
    }

    @Override
    public SharingDetailDetailDto updateSharingDetail(UUID sharingDetailId, SharingDetailDetailDto sharingDetailDetailDto) {
        SharingDetailEntity sharingDetailEntity = sharingDetailMapper.fromSharingDetailUpdateDto(sharingDetailDetailDto);
        sharingDetailEntity.setSharingDetailId(sharingDetailId);
        if(sharingDetailEntity == null){
            return null;
        }
        sharingDetailRepository.save(sharingDetailEntity);
        SharingDetailDetailDto sharingDetailDetailDtoUpdate = sharingDetailMapper.fromEntityToDto(sharingDetailEntity);
        return sharingDetailDetailDtoUpdate;
    }

    @Override
    public String deleteById(UUID sharingDetailId) {
        sharingDetailRepository.deleteById(sharingDetailId);
        return "Deleted";
    }

    @Override
    public List<SharingDetailDetailDto> findSDBySharingId(UUID sharingId) {
        return sharingDetailMapper.fromListEntityToDto(sharingDetailRepository.findSDBySharingId(sharingId));
    }
}