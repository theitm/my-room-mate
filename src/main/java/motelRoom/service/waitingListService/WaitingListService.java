package motelRoom.service.waitingListService;

import motelRoom.dto.waitingList.WaitingListBasicDto;
import motelRoom.dto.waitingList.WaitingListCreateDto;
import motelRoom.dto.waitingList.WaitingListDetailDto;

import java.util.List;
import java.util.UUID;

public interface WaitingListService {
    List<WaitingListDetailDto> getAllByUserId(UUID id);
    List<WaitingListDetailDto> getAllWaitingList();
    List<WaitingListBasicDto> getListByUserId(UUID id);
    WaitingListDetailDto addWaitingList(WaitingListCreateDto createDto);
    void deleteWaitingList(UUID id);
}
