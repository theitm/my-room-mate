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


/** Tạo room */
    public RoomDetailDto createRoom(RoomCreateDto roomCreateDto) {
        RoomEntity roomEntity = roomMapper.fromRoomCreateDto(roomCreateDto);
        RoomEntity roomEntityCreate = roomRepository.save(roomEntity);
        RoomDetailDto roomDetailDto = null;
        if(roomEntityCreate != null){
            roomDetailDto = roomMapper.fromEntityToDetailDto(roomEntityCreate);
        }
        return roomDetailDto;
    }


    public RoomDetailDto findById(UUID id) {
        RoomDetailDto roomDetailDto = roomMapper.fromEntityToDetailDto(roomRepository.getById(id));
        return roomDetailDto;
    }
/** cập nhật room **/

    public RoomDetailDto updateRoom(UUID id, RoomCreateDto roomCreateDto) {
        RoomEntity roomEntity = roomMapper.fromRoomCreateDto(roomCreateDto);
        roomEntity.setRoom_id(id);
        roomRepository.save(roomEntity);
        RoomDetailDto roomDetailDto = roomMapper.fromEntityToDetailDto(roomEntity);
        return roomDetailDto;
    }


    public void deleteById(UUID id) {
        roomRepository.deleteById(id);
    }


    public List<RoomDetailDto> findAll() {
        return roomMapper.fromEntityToDto(roomRepository.findAll());
    }


}