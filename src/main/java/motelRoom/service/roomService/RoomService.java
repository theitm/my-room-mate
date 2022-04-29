package motelRoom.service.roomService;

import motelRoom.dto.room.RoomBasicDto;
import motelRoom.dto.room.RoomCreateDto;
import motelRoom.dto.room.RoomDetailDto;
import org.springframework.data.domain.Sort;


import java.util.List;
import java.util.UUID;

public interface RoomService {
    RoomDetailDto findById(UUID id);
    RoomBasicDto findByIdObject(UUID id);
    RoomDetailDto updateRoom(UUID id, RoomCreateDto roomCreateDto);
    void deleteById(UUID id);
    List<RoomDetailDto> findAll();
    List<RoomBasicDto> findAllObject();
    RoomDetailDto createRoom(RoomCreateDto roomCreateDto);
    List<RoomDetailDto> findMultiSearch(UUID userId, int provinceId, float price, float capacity);
    List<RoomDetailDto> findMultiSearchs(float price, float capacity, int provinceId, int districtId);
    List<RoomDetailDto> findMultiSearch2Filter(int provinceId, float price);
    List<RoomDetailDto> findMultiSearch2Filters(int provinceId, float capacity);
    List<RoomDetailDto> findMultiSearch3Filters(int provinceId, int districtId,int wardId ,float price, float capacity);
    List<RoomDetailDto> findMultiSearch4Filters(int provinceId, int districtId,int wardId ,float price, float capacity);
    List<RoomDetailDto> findMultiSearch5Filters(int provinceId, int districtId,int wardId ,float price, float capacity);
}