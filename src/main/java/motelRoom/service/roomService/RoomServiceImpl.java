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

@Override
public RoomDetailDto createRoom(RoomCreateDto roomCreateDto) {
    RoomEntity roomEntity = roomMapper.fromDtoCreateEntity(roomCreateDto);
    RoomEntity roomEntity1 = roomRepository.save(roomEntity);
    RoomDetailDto roomDetailDto = roomMapper.fromEntityToDetailDto(roomEntity1);
    return roomDetailDto;
}

    @Override
    public void deleteByUserId(UUID user_id) {

    }


    /** Tim room theo id */

    public RoomDetailDto findById(UUID id) {
        RoomDetailDto roomDetailDto = roomMapper.fromEntityToDetailDto(roomRepository.getById(id));
        return roomDetailDto;
    }

    @Override
    public List<RoomDetailDto> findByUserId(UUID user_id) {
        return roomMapper.fromEntitíesToDto(roomRepository.findRoomByUserId(user_id));
    }


    @Override


    /** cập nhật room **/
    public RoomDetailDto updateRoom(UUID id, RoomCreateDto roomCreateDto){
        RoomEntity roomEntity = roomMapper.fromDtoCreateEntity(roomCreateDto);
        RoomEntity roomEntity1 = roomRepository.save(roomEntity);
        RoomDetailDto roomDetailDto = null;
        if(roomEntity1 != null) {
            roomDetailDto = roomMapper.fromEntityToDetailDto(roomEntity1);
        }
        return roomDetailDto;
    }

/** Xoa room **/
    public void deleteById(UUID id) {

        roomRepository.deleteById(id);
    }

/** Get all room **/
    public List<RoomDetailDto> findAll() {
        return roomMapper.fromEntitíesToDto(roomRepository.findAll());
    }
}