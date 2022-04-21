package motelRoom.service.waitingListService;

import motelRoom.dto.waitingList.WaitingListCreateDto;
import motelRoom.dto.waitingList.WaitingListDetailDto;
import java.util.List;
import java.util.UUID;

public interface WaitingListService {
    List<WaitingListDetailDto> getAllWaitingList();
    List<WaitingListDetailDto> getAllByUserId(UUID id);
    WaitingListDetailDto addWaitingList(WaitingListCreateDto createDto);
    void deleteWaitingList(UUID id);
}
