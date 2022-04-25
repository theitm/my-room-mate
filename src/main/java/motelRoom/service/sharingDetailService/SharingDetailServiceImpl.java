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

    /**
     * Create SharingDetail
     **/
    @Override
    public String createSharingDetail(SharingDetailCreateDto sharingDetailCreateDto) {
        UUID entity = sharingDetailCreateDto.getUser_id();
        UUID entity2 = sharingDetailCreateDto.getSharingId();
        if(entity == null || entity2 == null){
            return "Please enter information";
        }
        else {
            SharingDetailEntity user = sharingDetailRepository.findByUserId(sharingDetailCreateDto.getUser_id());
            if (user != null) {
                return "User ID has existed!";
            }
            else {
                SharingDetailEntity sharingDetailEntity = sharingDetailMapper.fromSharingDetailCreateDto(sharingDetailCreateDto);
                SharingDetailEntity sharingDetailEntityCreate = sharingDetailRepository.save(sharingDetailEntity);
                SharingDetailDetailDto sharingDetailDetailDto = null;
                if(sharingDetailEntityCreate != null){
                    sharingDetailDetailDto = sharingDetailMapper.fromEntityToDto(sharingDetailEntityCreate);
                }
                return "Created!";
            }
        }
    }

    /**
     * Show SharingDetail by id
     **/
    @Override
    public SharingDetailDetailDto findById(UUID sharingDetailId) {
        SharingDetailDetailDto sharingDetailDetailDto = sharingDetailMapper.fromEntityToDto(sharingDetailRepository.getById(sharingDetailId));
        return sharingDetailDetailDto;
    }

    /**
     * Show list SharingDetail
     **/
    @Override
    public List<SharingDetailDetailDto> findAll() {
        return sharingDetailMapper.fromListEntitiesToDtos(sharingDetailRepository.findAll());
    }

    /**
     * Update SharingDetail by id
     **/
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

    /**
     * Delete SharingDetail by id
     **/
    @Override
    public String deleteById(UUID sharingDetailId) {
        sharingDetailRepository.deleteById(sharingDetailId);
        return "Deleted";
    }

}