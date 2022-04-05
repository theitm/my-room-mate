package motelRoom.service.waitingListService;

import motelRoom.dto.waitingList.WaitingListCreateDto;
import motelRoom.dto.waitingList.WaitingListDetailDto;
import motelRoom.entity.WaitingListEntity;
import motelRoom.mapper.WaitingListMapper;
import motelRoom.repository.WaitingListRepository;
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
    @Override
    public List<WaitingListDetailDto> getAllWaitingList()
    {
        return mapper.fromEntitiesToDto(repository.findAll());
    }
    @Override
    public WaitingListDetailDto getById(UUID id)
    {
        return mapper.fromEntityToDetailDto(repository.getById(id));
    }
    @Override
    public WaitingListDetailDto addWaitingList(WaitingListCreateDto waitingListCreateDto)
    {
        WaitingListEntity waitingListEntity = mapper.fromDtoCreateEntity(waitingListCreateDto);
        WaitingListEntity waitingListEntity2 = repository.save(waitingListEntity);
        return mapper.fromEntityToDetailDto(waitingListEntity2);
    }
    @Override
    public void deleteWaitingList(UUID id) {
        repository.deleteById(id);
    }
}
