package motelRoom.service.waitingListService;

import motelRoom.dto.waitingList.WaitingListCreateDto;
import motelRoom.dto.waitingList.WaitingListDetailDto;
import motelRoom.entity.WaitingListEntity;
import motelRoom.mapper.WaitingListMapper;
import motelRoom.repository.WaitingListRepository;
import motelRoom.service.exceptionService.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WaitingListServiceImpl implements WaitingListService{
    @Autowired
    private  WaitingListRepository repository;
    @Autowired
    private WaitingListMapper mapper;

    public WaitingListServiceImpl(WaitingListRepository repository, WaitingListMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * get all room in Waiting List
     * @return
     */
    @Override
    public List<WaitingListDetailDto> getAllWaitingList()
    {
        return mapper.fromEntitiesToDto(repository.findAll());
    }

    /**
     * get all room in Waiting List by id
     * @param id
     * @return
     */
    @Override
    public List<WaitingListDetailDto> getAllByUserId(UUID id) {
         List<WaitingListDetailDto> list = mapper.fromEntitiesToDto(repository.getAllByUserId(id));
         if(list.isEmpty()){
             throw new NotFoundException("Not find");
         }
        return list;
    }

    /**
     * get room in Waiting List by id
     * @param id
     * @return
     */
    @Override
    public WaitingListDetailDto getById(UUID id)
    {
        try{
            return mapper.fromEntityToDetailDto(repository.getById(id));
        }catch (Exception e){
            throw new NotFoundException("Not find");
        }
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
