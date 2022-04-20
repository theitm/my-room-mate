package motelRoom.controller;

import motelRoom.dto.room.RoomDetailDto;
import motelRoom.dto.waitingList.WaitingListCreateDto;
import motelRoom.dto.waitingList.WaitingListDetailDto;
import motelRoom.service.waitingListService.RoomExcelExporter;
import motelRoom.service.waitingListService.WaitingListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/WaitingList")
public class WaitingListController {
    @Autowired
    WaitingListServiceImpl service;

    /**
     * get all room in Waiting List
     * @return
     */
    @GetMapping("")
    public ResponseEntity<List<WaitingListDetailDto>> getAll()
    {
         return ResponseEntity.ok(service.getAllWaitingList());
    }

    /**
     * get room in Waiting List by id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<WaitingListDetailDto> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    /**
     * get all room in Waiting List by id
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    public ResponseEntity<List<WaitingListDetailDto>> getAllByUserId(@PathVariable(name = "id") UUID id){
        return ResponseEntity.ok(service.getAllByUserId(id));
    }

    /**
     * add room to Waiting List
     * @param createDto
     * @return
     */
    @PostMapping("")
    public ResponseEntity<WaitingListDetailDto> addWaitingList(@RequestBody WaitingListCreateDto createDto)
    {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.addWaitingList(createDto));
    }

    /**
     * delete room in waiting List
     * @param id
     */
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id) {
        service.deleteWaitingList(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Deleted");
    }

    /** get room excel **/
    @GetMapping("/export")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";

        String headerValue = "attachment; filename=room_waiting_list.xlsx";

        response.setHeader(headerKey, headerValue);

        List<WaitingListDetailDto> listRooms = service.getAllWaitingList();

        RoomExcelExporter excelExporter = new RoomExcelExporter(listRooms);
        excelExporter.export(response);
    }
}
