package motelRoom.service.roomSharingService;

import motelRoom.dto.roomSharing.RoomSharingCreateDto;
import motelRoom.dto.roomSharing.RoomSharingDetailDto;
import motelRoom.dto.sharingDetail.SharingDetailCreateDto;
import motelRoom.entity.RoomSharingEntity;
import motelRoom.mapper.RoomSharingMapper;
import motelRoom.repository.RoomSharingRepository;
import motelRoom.service.sharingDetailService.SharingDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class RoomSharingServiceImpl implements RoomSharingService{

    @Autowired
    private final RoomSharingRepository roomSharingRepository;
    @Autowired
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
    public RoomSharingDetailDto updateRoomSharing(UUID sharing_id, RoomSharingCreateDto roomSharingCreateDto) {
        RoomSharingEntity roomSharingEntity = roomSharingMapper.fromRoomSharingCreateDto(roomSharingCreateDto);
        roomSharingEntity.setSharing_id(sharing_id);
        roomSharingRepository.save(roomSharingEntity);
        RoomSharingDetailDto roomSharingDetailDto = roomSharingMapper.fromEntityToDto(roomSharingEntity);
        return roomSharingDetailDto;
    }

    @Override
    public void deleteById(UUID sharing_id) {
        roomSharingRepository.deleteById(sharing_id);
    }

    @Override
    public RoomSharingDetailDto createRoomSharing(RoomSharingCreateDto roomSharingCreateDto) {
        RoomSharingEntity roomSharingEntity = roomSharingMapper.fromRoomSharingCreateDto(roomSharingCreateDto);
        roomSharingEntity.setSharingDetailEntities(null);
        RoomSharingEntity roomSharingCreateEntity = roomSharingRepository.save(roomSharingEntity);
        for (SharingDetailCreateDto sharingDetailCreateDto : roomSharingCreateDto.getSharingDetailEntities()){
            sharingDetailCreateDto.setSharing_id(roomSharingCreateEntity.getSharing_id());
            sharingDetailService.createSharingDetail(sharingDetailCreateDto);
        }
        return null;
    }
}
