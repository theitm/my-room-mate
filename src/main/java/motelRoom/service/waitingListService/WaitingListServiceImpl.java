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
    private final WaitingListRepository repository;
    @Autowired
    private final WaitingListMapper mapper;

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
        WaitingListDetailDto dto = mapper.fromEntityToDetailDto(repository.getById(id));
        return dto;
    }

    @Override
    public WaitingListDetailDto addWaitingList(WaitingListCreateDto waitingListCreateDto)
    {
        WaitingListEntity waitingListEntity = mapper.fromDtoCreateEntity(waitingListCreateDto);
        WaitingListEntity waitingListEntity2 = repository.save(waitingListEntity);

        WaitingListDetailDto waitingListDetailDto = mapper.fromEntityToDetailDto(waitingListEntity2);
        return waitingListDetailDto;
    }

    @Override
    public Void Delete(UUID id) {
        repository.deleteById(id);
        return null;
    }



}
