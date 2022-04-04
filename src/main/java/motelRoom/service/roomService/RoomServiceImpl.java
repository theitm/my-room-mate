package motelRoom.service.roomService;
import motelRoom.dto.room.RoomCreateDto;
import motelRoom.dto.room.RoomDetailDto;
import motelRoom.entity.RoomEntity;
import motelRoom.mapper.RoomMapper;
import motelRoom.repository.RoomRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    public RoomServiceImpl(RoomRepository roomRepository, RoomMapper roomMapper) {
        this.roomRepository = roomRepository;
        this.roomMapper = roomMapper;
    }

    /** Create room */
    @Override
    public RoomDetailDto createRoom(RoomCreateDto roomCreateDto) {
        RoomEntity roomEntity = roomMapper.fromDtoCreateEntity(roomCreateDto);
        RoomEntity roomEntity1 = roomRepository.save(roomEntity);
        RoomDetailDto roomDetailDto = roomMapper.fromEntityToDetailDto(roomEntity1);
        return roomDetailDto;
    }

    /** Delete room by user_id */
    @Override
    public void deleteByUserId(UUID user_id) {
        roomRepository.deleteById(user_id);
    }

    /** Get by id */
    public RoomDetailDto findById(UUID id) {
        RoomDetailDto roomDetailDto = roomMapper.fromEntityToDetailDto(roomRepository.getById(id));
        return roomDetailDto;
    }

    /** Get by user_id */
    @Override
    public List<RoomDetailDto> findByUserId(UUID user_id) {
        return roomMapper.fromEntitíesToDto(roomRepository.findRoomByUserId(user_id));
    }

    /** Update room **/
    @Override
    public RoomDetailDto updateRoom(UUID id, RoomCreateDto roomCreateDto){
        RoomEntity roomEntity = roomMapper.fromDtoCreateEntity(roomCreateDto);
        roomEntity.setRoom_id(id);
        roomRepository.save(roomEntity);
        RoomDetailDto roomDetailDto = roomMapper.fromEntityToDetailDto(roomEntity);
        return roomDetailDto;
    }

    /** Delete room **/
    public void deleteById(UUID id) {
        roomRepository.deleteById(id);
    }

    /** Get all room **/
    public List<RoomDetailDto> findAll() {
        return roomMapper.fromEntitíesToDto(roomRepository.findAll());
    }
}