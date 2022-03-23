package motelRoom.service.roomService;

import motelRoom.dto.room.RoomDetailDto;
import motelRoom.mapper.RoomMapper;
import motelRoom.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoomServiceImpl implements RoomService{

   private final RoomRepository repository;
   private final RoomMapper mapper;

   public RoomServiceImpl(RoomRepository repository, RoomMapper mapper){
       this.repository = repository;
       this.mapper = mapper;
   }

    @Override
    public List<RoomDetailDto> getAllRoom() {
        return mapper.fromEntitiesToDto(repository.findAll());
    }

    @Override
    public RoomDetailDto getById(UUID id) {
       RoomDetailDto dto = mapper.fromEntityToDetailDto(repository.getById(id));
        return dto;
    }
}
