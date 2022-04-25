package motelRoom.service.roomService;
import motelRoom.dto.room.RoomCreateDto;
import motelRoom.dto.room.RoomDetailDto;
import motelRoom.entity.RoomEntity;
import motelRoom.mapper.RoomMapper;
import motelRoom.repository.RoomRepository;
import org.springframework.beans.BeanUtils;
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

    /** find multi search 1 filter */
    @Override
    public List<RoomDetailDto> findMultiSearch(UUID userId, int provinceId, float price, float capacity) {
        return roomMapper.fromEntitíesToDtos(roomRepository.searchAllByUserIdOrProvinceIdOrPriceOrCapacity(userId,provinceId,price,capacity));
    }

    /** find multi search 2 filter */
    @Override
    public List<RoomDetailDto> findMultiSearchs(float price, float capacity, int provinceId, int districtId) {
         return roomMapper.fromEntitíesToDtos(roomRepository.searchRoomEntitiesByPriceAndCapacityOrProvinceIdAndDistrictId(price,capacity,provinceId,districtId));
    }

    /** find multi search 2 filter */
    @Override
    public List<RoomDetailDto> findMultiSearch2Filter(int provinceId, float price) {
        return roomMapper.fromEntitíesToDtos(roomRepository.searchRoomEntitiesByProvinceIdAndPrice(provinceId,price));
    }

    /** find multi search 2 filter */
    @Override
    public List<RoomDetailDto> findMultiSearch2Filters(int provinceId, float capacity) {
        return roomMapper.fromEntitíesToDtos(roomRepository.searchRoomEntitiesByProvinceIdAndCapacity(provinceId,capacity));
    }

    /** find multi search 3 filter */
    @Override
    public List<RoomDetailDto> findMultiSearch3Filters(int provinceId, int districtId, int wardId, float price, float capacity) {
        return roomMapper.fromEntitíesToDtos(roomRepository.multiSearch3Filter(provinceId, districtId, wardId, price, capacity));
    }

    /** find multi search 4 filter */
    @Override
    public List<RoomDetailDto> findMultiSearch4Filters(int provinceId, int districtId, int wardId, float price, float capacity) {
        return roomMapper.fromEntitíesToDtos(roomRepository.multiSearch4Filter(provinceId, districtId, wardId, price, capacity));
    }

    /** find multi search 5 filter */
    @Override
    public List<RoomDetailDto> findMultiSearch5Filters(int provinceId, int districtId, int wardId, float price, float capacity) {
        return roomMapper.fromEntitíesToDtos(roomRepository.searchRoomEntitiesByProvinceIdAndDistrictIdAndWardIdAndPriceAndCapacity(provinceId, districtId, wardId, price, capacity));
    }

    /** Get by id */
    public RoomDetailDto findById(UUID id) {
        RoomDetailDto roomDetailDto = roomMapper.fromEntityToDetailDto(roomRepository.getById(id));
        return roomDetailDto;
    }

    /** Update room **/
    @Override
    public RoomDetailDto updateRoom(UUID id, RoomCreateDto roomCreateDto){
        RoomEntity roomEntity = roomRepository.findById(id).orElse(null);
        if(roomEntity == null){
            return null;
        }
        BeanUtils.copyProperties(roomCreateDto, roomEntity);
        roomRepository.saveAndFlush(roomEntity);
        return roomMapper.fromEntityToDetailDto(roomEntity);
    }

    /** Delete room **/
    public void deleteById(UUID id) {
        roomRepository.deleteById(id);
    }

    /** Get all room **/
    public List<RoomDetailDto> findAll() {
        return roomMapper.fromEntitíesToDtos(roomRepository.findAll());
    }
}