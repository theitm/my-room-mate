package motelRoom.service.roomSharingService;

import motelRoom.dto.roomSharing.RoomSharingCreateDto;
import motelRoom.dto.roomSharing.RoomSharingDetailDto;
import motelRoom.dto.sharingDetail.SharingDetailCreateDto;
import motelRoom.entity.RoomSharingEntity;
import motelRoom.mapper.RoomSharingMapper;
import motelRoom.repository.RoomSharingRepository;
import motelRoom.service.sharingDetailService.SharingDetailService;
import org.springframework.stereotype.Service;
import java.util.List;
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
    public RoomSharingDetailDto findById(UUID sharingId) {
        RoomSharingDetailDto roomSharingDetailDto = roomSharingMapper.fromEntityToDto(roomSharingRepository.getById(sharingId));
        return roomSharingDetailDto;
    }

    @Override
    public List<RoomSharingDetailDto> getAllRoomSharing() {
        return roomSharingMapper.fromListEntityToDto(roomSharingRepository.findAll());
    }

    @Override
    public RoomSharingDetailDto updateRoomSharing(UUID sharingId, RoomSharingDetailDto roomSharingDetailDto) {
        RoomSharingEntity roomSharingEntity = roomSharingMapper.fromRoomSharingCreateDto(roomSharingDetailDto);
        roomSharingEntity.setSharingId(sharingId);
        if(roomSharingEntity == null){
            return null;
        }
        roomSharingRepository.save(roomSharingEntity);
        RoomSharingDetailDto roomSharingDetailDtoUpdate = roomSharingMapper.fromEntityToDto(roomSharingEntity);
        return roomSharingDetailDtoUpdate;
    }

    @Override
    public String deleteById(UUID sharingId) {
        roomSharingRepository.deleteById(sharingId);
        return "Deleted";
    }

    @Override
    public String createRoomSharing(RoomSharingCreateDto roomSharingCreateDto) {
        RoomSharingEntity roomSharingEntity = roomSharingMapper.fromRoomSharingCreateDto(roomSharingCreateDto);
        RoomSharingEntity roomSharingCreateEntity = roomSharingRepository.save(roomSharingEntity);
        for (SharingDetailCreateDto sharingDetailCreateDto : roomSharingCreateDto.getSharingDetails()){
            sharingDetailCreateDto.setRole("Key");
            sharingDetailCreateDto.setSharingId(roomSharingCreateEntity.getSharingId());
            sharingDetailService.createSharingDetail(sharingDetailCreateDto);
        }
        return "Created";
    }
}