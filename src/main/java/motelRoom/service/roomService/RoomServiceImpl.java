package motelRoom.service.roomService;
import motelRoom.dto.room.RoomBasicDto;
import motelRoom.dto.room.RoomCreateDto;
import motelRoom.dto.room.RoomDetailDto;
import motelRoom.entity.RoomEntity;
import motelRoom.mapper.RoomMapper;
import motelRoom.repository.RoomRepository;
import motelRoom.service.exceptionService.NotAcceptable;
import motelRoom.service.exceptionService.NotFoundException;
import org.aspectj.bridge.Message;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Sort;
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
        UUID user = roomCreateDto.getUserId();
        if(user == null){
            throw new NotAcceptable("Please enter information");
        }
        else{
            RoomEntity roomEntity = roomMapper.fromRoomCreateEntityDto(roomCreateDto);
            RoomEntity roomEntityCreate = roomRepository.save(roomEntity);
            RoomDetailDto roomDetailDto = roomMapper.fromEntityToDetailDto(roomEntityCreate);
            return roomDetailDto;
        }
    }

    /** find multi search 1 filter */
    @Override
    public List<RoomDetailDto> findMultiSearch(UUID userId, int provinceId, float price, float capacity) {
        return roomMapper.fromEntitiesToDtos(roomRepository.
                searchAllByUserIdOrProvinceIdOrPriceOrCapacity(userId,provinceId,price,capacity));
    }

    /** find multi search 2 filter */
    @Override
    public List<RoomDetailDto> findMultiSearchs(float price, float capacity, int provinceId, int districtId) {
         return roomMapper.fromEntitiesToDtos(roomRepository.
                 searchRoomEntitiesByPriceAndCapacityOrProvinceIdAndDistrictId(price,capacity,provinceId,districtId));
    }

    /** find multi search 2 filter */
    @Override
    public List<RoomDetailDto> findMultiSearch2Filter(int provinceId, float price) {
        return roomMapper.fromEntitiesToDtos(roomRepository.
                searchRoomEntitiesByProvinceIdAndPrice(provinceId,price));
    }

    /** find multi search 2 filter */
    @Override
    public List<RoomDetailDto> findMultiSearch2Filters(int provinceId, float capacity) {
        return roomMapper.fromEntitiesToDtos(roomRepository.
                searchRoomEntitiesByProvinceIdAndCapacity(provinceId,capacity));
    }

    /** find multi search 3 filter */
    @Override
    public List<RoomDetailDto> findMultiSearch3Filters(int provinceId, int districtId, int wardId, float price, float capacity) {
        return roomMapper.fromEntitiesToDtos(roomRepository.
                multiSearch3Filter(provinceId, districtId, wardId, price, capacity));
    }

    /** find multi search 4 filter */
    @Override
    public List<RoomDetailDto> findMultiSearch4Filters(int provinceId, int districtId, int wardId, float price, float capacity) {
        return roomMapper.fromEntitiesToDtos(roomRepository.
                multiSearch4Filter(provinceId, districtId, wardId, price, capacity));
    }

    /** find multi search 5 filter */
    @Override
    public List<RoomDetailDto> findMultiSearch5Filters(int provinceId, int districtId, int wardId, float price, float capacity) {
        return roomMapper.fromEntitiesToDtos(roomRepository.
                searchRoomEntitiesByProvinceIdAndDistrictIdAndWardIdAndPriceAndCapacity(provinceId, districtId, wardId, price, capacity));
    }


    /** Get by id */
    public RoomDetailDto findById(UUID id) {
        try{
            RoomDetailDto roomDetailDto = roomMapper.fromEntityToDetailDto(roomRepository.getById(id));
            return roomDetailDto;
        }
        catch (Exception e){
            throw new NotAcceptable("Can't find Room with id: " + id);
        }

    }

    @Override
    public RoomBasicDto findByIdObject(UUID id) {
        try{
            RoomBasicDto roomBasicDto = roomMapper.fromEntityToBasicDto(roomRepository.getById(id));
            return roomBasicDto;
        }
        catch (Exception e){
            throw new NotAcceptable("Can't find Room with id: " + id);
        }
    }

    /** Update room **/
    @Override
    public RoomDetailDto updateRoom(UUID id, RoomCreateDto roomCreateDto){
        UUID user = roomCreateDto.getUserId();
        if(user == null){
            return null;
        }
        else{
            RoomEntity roomEntity = roomRepository.findById(id).orElse(null);
            if(roomEntity == null){
                return null;
            }
            BeanUtils.copyProperties(roomCreateDto, roomEntity);
            roomRepository.saveAndFlush(roomEntity);
            return roomMapper.fromEntityToDetailDto(roomEntity);
        }
    }

    /** Delete room **/
    public void deleteById(UUID id) {
        try {
            roomRepository.deleteById(id);
        }
        catch (Exception e){
            throw new NotFoundException("Not find id!");
        }

    }

    /** Get all room **/
    @Override
    public List<RoomDetailDto> findAll() {
        return roomMapper.fromEntitiesToDtos(roomRepository.findAll());
    }

    @Override
    public List<RoomBasicDto> findAllObject() {
        return roomMapper.fromEntitiesToBasicDtos(roomRepository.findAll());
    }
}