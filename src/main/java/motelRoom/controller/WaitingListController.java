package motelRoom.controller;

import motelRoom.dto.waitingList.WaitingListBasicDto;
import motelRoom.dto.waitingList.WaitingListCreateDto;
import motelRoom.dto.waitingList.WaitingListDetailDto;
import motelRoom.service.userService.UserService;
import motelRoom.service.waitingListService.RoomExcelExporter;
import motelRoom.service.waitingListService.WaitingListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/waitinglist")
public class WaitingListController {
    @Autowired
    WaitingListServiceImpl service;
    @Autowired
    UserService userService;

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

    /** get room excel user current **/
    @GetMapping("/export")
    public void exportToExcel(HttpServletResponse response, Authentication authentication) throws IOException {
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=room_waiting_list.xlsx";
        response.setHeader(headerKey, headerValue);
        List<WaitingListBasicDto> listRooms = service.getListByUserId(userService.findByUserName(authentication.getName()).getId());
        RoomExcelExporter excelExporter = new RoomExcelExporter(listRooms);
        excelExporter.export(response);
    }
}
