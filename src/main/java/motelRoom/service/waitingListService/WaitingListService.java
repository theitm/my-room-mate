package motelRoom.service.waitingListService;

import motelRoom.dto.waitingList.WaitingListCreateDto;
import motelRoom.dto.waitingList.WaitingListDetailDto;

import java.util.List;
import java.util.UUID;

public interface WaitingListService {
    /**.....get all room in Waiting List...........**/
    List<WaitingListDetailDto> getAllWaitingList();
    /**.....get all room in Waiting List by User Id...........**/
    List<WaitingListDetailDto> getAllByUserId(UUID id);
    /**.....get room in Waiting List by id...........**/
    WaitingListDetailDto getById(UUID id);
    /**.....add room to Waiting List...........**/
    WaitingListDetailDto addWaitingList(WaitingListCreateDto createDto);
    /**.....delete room in waiting List...........**/
    void deleteWaitingList(UUID id);

}
