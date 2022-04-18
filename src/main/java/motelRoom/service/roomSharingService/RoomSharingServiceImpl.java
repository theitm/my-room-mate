package motelRoom.service.roomSharingService;

import motelRoom.dto.roomSharing.RoomSharingCreateDto;
import motelRoom.dto.roomSharing.RoomSharingDetailDto;
import motelRoom.dto.sharingDetail.SharingDetailCreateDto;
import motelRoom.entity.RoomSharingEntity;
import motelRoom.entity.SharingDetailEntity;
import motelRoom.mapper.RoomSharingMapper;
import motelRoom.repository.RoomSharingRepository;
import motelRoom.repository.SharingDetailRepository;
import motelRoom.service.exceptionService.NotAcceptable;
import motelRoom.service.sharingDetailService.SharingDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class RoomSharingServiceImpl implements RoomSharingService{
    @Autowired
    SharingDetailRepository repository;

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

    /**
     * Show RoomSharing by sharingId
     **/
    @Override
    public RoomSharingDetailDto findById(UUID sharingId) {
        try {
            RoomSharingDetailDto roomSharingDetailDto = roomSharingMapper.fromEntityToDto(roomSharingRepository.getById(sharingId));
            return roomSharingDetailDto;
        }
        catch (Exception e)
        {
            throw new NotAcceptable("can't find RoomSharing with id: " + sharingId);
        }
    }

    /**
     * Show list RoomSharing
     **/
    @Override
    public List<RoomSharingDetailDto> getAllRoomSharing() {
        return roomSharingMapper.fromListEntitiesToDtos(roomSharingRepository.findAll());
    }

    /**
     * Update RoomSharing by sharingId
     **/
    @Override
    public RoomSharingDetailDto updateRoomSharing(UUID sharingId, RoomSharingDetailDto roomSharingDetailDto) {
        RoomSharingEntity roomSharingEntity = roomSharingMapper.fromRoomSharingCreateDto(roomSharingDetailDto);
        roomSharingEntity.setSharingId(sharingId);
        if (roomSharingEntity == null) {
            return null;
        }
        roomSharingRepository.save(roomSharingEntity);
        RoomSharingDetailDto roomSharingDetailDtoUpdate = roomSharingMapper.fromEntityToDto(roomSharingEntity);
        return roomSharingDetailDtoUpdate;
    }

    /**
     * Delete RoomSharing by sharingId
     **/
    @Override
    public String deleteById(UUID sharingId) {
        try {
            roomSharingRepository.deleteById(sharingId);
            return "Deleted";
        }
        catch (Exception e)
        {
            throw new NotAcceptable("can't find RoomSharing with id: " + sharingId +" to delete!");
        }
    }

    /**
     * Create RoomSharing
     **/
    @Override
    public String createRoomSharing(RoomSharingCreateDto roomSharingCreateDto) {
        List<SharingDetailCreateDto> ListDto = roomSharingCreateDto.getSharingDetails();

        for (SharingDetailCreateDto dto: ListDto
             ) {
            SharingDetailEntity entity = repository.findByUserId(dto.getUser_id());
            if(entity != null)
            {
                return "You created Room Sharing before!";
            }
        }

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