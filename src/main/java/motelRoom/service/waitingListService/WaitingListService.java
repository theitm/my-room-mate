package motelRoom.service.waitingListService;

import motelRoom.dto.waitingList.WaitingListCreateDto;
import motelRoom.dto.waitingList.WaitingListDetailDto;

import java.util.List;
import java.util.UUID;

public interface WaitingListService {
    public List<WaitingListDetailDto> getAllWaitingList();
    public WaitingListDetailDto getById(UUID id);
    public WaitingListDetailDto addWaitingList(WaitingListCreateDto createDto);
}
