package motelRoom.service.waitingListService;

import motelRoom.dto.waitingList.WaitingListBasicDto;
import motelRoom.dto.waitingList.WaitingListCreateDto;
import motelRoom.dto.waitingList.WaitingListDetailDto;
import motelRoom.entity.WaitingListEntity;
import motelRoom.mapper.WaitingListMapper;
import motelRoom.repository.WaitingListRepository;
import motelRoom.service.exceptionService.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class WaitingListServiceImpl implements WaitingListService{
    @Autowired
    private  WaitingListRepository repository;
    @Autowired
    private WaitingListMapper mapper;

    /**
     * get all room in Waiting List
     * @return
     */
    @Override
    public List<WaitingListDetailDto> getAllWaitingList()
    {
        return mapper.fromEntitiesToDetailDtos(repository.findByOrderByDateTimeDesc());
    }

    /**
     * get list room in Waiting List by user id
     * @param id
     * @return
     */
    @Override
    public List<WaitingListBasicDto> getListByUserId(UUID id) {
        List<WaitingListBasicDto> list = mapper.fromEntitiesToBasicDtos(repository.getAllByUserId(id));
        if(list.isEmpty()){
            throw new NotFoundException("Not find");
        }
        return list;
    }

    /**
     * get all room in Waiting List by id
     * @param id
     * @return
     */
    @Override
    public List<WaitingListDetailDto> getAllByUserId(UUID id) {
         List<WaitingListDetailDto> list = mapper.fromEntitiesToDetailDtos(repository.findByUserIdOrderByDateTimeDesc(id));
         if(list.isEmpty()){
             throw new NotFoundException("Not find");
         }
        return list;
    }

    /**
     * add room to Waiting List
     * @param waitingListCreateDto
     * @return
     */
    @Override
    public WaitingListDetailDto addWaitingList(WaitingListCreateDto waitingListCreateDto)
    {
        WaitingListEntity entity = mapper.fromDtoCreateEntity(waitingListCreateDto);
        entity.setDateTime(LocalDateTime.now());
        WaitingListEntity entitySave = repository.save(entity);
        return mapper.fromEntityToDetailDto(entitySave);
    }

    /**
     * delete room in waiting List
     * @param id
     */
    @Override
    public void deleteWaitingList(UUID id) {
        try{
            repository.deleteById(id);
        }catch (Exception e){
           throw new  NotFoundException("Not find id");
        }
    }
}
