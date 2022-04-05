package motelRoom.service.roomSharingService;

import motelRoom.dto.roomSharing.RoomSharingCreateDto;
import motelRoom.dto.roomSharing.RoomSharingDetailDto;
import motelRoom.dto.sharingDetail.SharingDetailCreateDto;
import motelRoom.dto.sharingDetail.SharingDetailDetailDto;
import motelRoom.entity.RoomSharingEntity;
import motelRoom.mapper.RoomSharingMapper;
import motelRoom.repository.RoomSharingRepository;
import motelRoom.service.sharingDetailService.SharingDetailService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;
@Service
public class RoomSharingServiceImpl implements RoomSharingService{

    private final RoomSharingRepository roomSharingRepository;
    private final RoomSharingMapper roomSharingMapper;
    private final SharingDetailService sharingDetailService;


    public RoomSharingServiceImpl(RoomSharingRepository roomSharingRepository,
                                  RoomSharingMapper roomSharingMapper,
                                  SharingDetailService sharingDetailService) {
        this.roomSharingRepository = roomSharingRepository;
        this.roomSharingMapper = roomSharingMapper;
        this.sharingDetailService = sharingDetailService;
    }

    @Override
    public RoomSharingDetailDto findById(UUID sharing_id) {
        RoomSharingDetailDto roomSharingDetailDto = roomSharingMapper.fromEntityToDto(roomSharingRepository.getById(sharing_id));
        return roomSharingDetailDto;
    }

    @Override
    public List<RoomSharingDetailDto> getAllRoomSharing() {
        return roomSharingMapper.fromListEntityToDto(roomSharingRepository.findAll());
    }



    @Override
    public RoomSharingDetailDto updateRoomSharing(UUID sharing_id, RoomSharingDetailDto roomSharingDetailDto) {
        RoomSharingEntity roomSharingEntity = roomSharingMapper.fromRoomSharingCreateDto(roomSharingDetailDto);
        roomSharingEntity.setSharing_id(sharing_id);
        if(roomSharingEntity == null){
            return null;
        }
        roomSharingRepository.save(roomSharingEntity);
        for (SharingDetailDetailDto sharingDetailDetailDto : roomSharingDetailDto.getSharingDetails()){
            sharingDetailDetailDto.setSharing_id(roomSharingEntity.getSharing_id());
            sharingDetailService.updateSharingDetail(sharing_id,sharingDetailDetailDto);
        }
        RoomSharingDetailDto roomSharingDetailDtoUpdate = roomSharingMapper.fromEntityToDto(roomSharingEntity);
        return roomSharingDetailDtoUpdate;
    }

//    @Override
//    public RoomSharingDetailDto updateRoomSharing(UUID sharing_id, RoomSharingCreateDto roomSharingCreateDto) {
//        RoomSharingEntity roomSharingEntity = roomSharingMapper.fromRoomSharingCreateDto(roomSharingCreateDto);
////        roomSharingEntity.setSharingDetails(null);
//        roomSharingEntity.setSharing_id(sharing_id);
//        roomSharingRepository.save(roomSharingEntity);
//        RoomSharingDetailDto roomSharingDetailDto = roomSharingMapper.fromEntityToDto(roomSharingEntity);
//        return roomSharingDetailDto;
//    }


    @Override
    public String deleteById(UUID sharing_id) {

        roomSharingRepository.deleteById(sharing_id);
        return "Deleted";
    }

    @Override
    public String createRoomSharing(RoomSharingCreateDto roomSharingCreateDto) {
        RoomSharingEntity roomSharingEntity = roomSharingMapper.fromRoomSharingCreateDto(roomSharingCreateDto);
        RoomSharingEntity roomSharingCreateEntity = roomSharingRepository.save(roomSharingEntity);
        for (SharingDetailCreateDto sharingDetailCreateDto : roomSharingCreateDto.getSharingDetails()){
            sharingDetailCreateDto.setSharing_id(roomSharingCreateEntity.getSharing_id());
            sharingDetailService.createSharingDetail(sharingDetailCreateDto);
        }

        return "Created";
    }
}
