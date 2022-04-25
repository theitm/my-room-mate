package motelRoom.controller;

import motelRoom.dto.room.RoomCreateDto;
import motelRoom.dto.room.RoomDetailDto;
import motelRoom.entity.RoomEntity;
import motelRoom.service.roomService.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/room")
public class RoomController {
    private final RoomService roomService;
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    /** Create room **/
    @PostMapping
    public RoomDetailDto createRoom(@RequestBody RoomCreateDto roomCreateDto)
    {
        return roomService.createRoom(roomCreateDto);
    }

    /** Get all room **/
    @GetMapping
    public List<RoomDetailDto> findAll()
    {
        return roomService.findAll();
    }

    /** Get by id **/
    @GetMapping("/{id}")
    public ResponseEntity<RoomDetailDto> findById(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(roomService.findById(id));
    }

    /** Delete room by id **/
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id) {
        roomService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    /** Update room **/
    @PutMapping("/{id}")
    public ResponseEntity<RoomDetailDto> updateRoom(@PathVariable UUID id,
                                                    @RequestBody RoomCreateDto roomCreateDto) {
        RoomDetailDto roomDetailDto = roomService.updateRoom(id, roomCreateDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(roomDetailDto);
    }
    /**
     * SearchFilter1
     */
    @PostMapping("/search")
    public List<RoomDetailDto> searchFilter(@RequestBody RoomDetailDto roomDetailDto)
    {
        List<RoomDetailDto> list = new ArrayList<>();
        /**
         * Multi Search No Filter
         */
        if(roomDetailDto.getUserId() == null &&
                roomDetailDto.getProvinceId()== 0 &&
                roomDetailDto.getWardId()==0 &&
                roomDetailDto.getDistrictId()==0 &&
                roomDetailDto.getPrice() == 0 &&
                roomDetailDto.getCapacity()==0){
            return findAll();
        }
        else {
            /**
             * Multi Search 1 Filter
             */
            if(roomDetailDto.getUserId() != null &&
                    roomDetailDto.getProvinceId() == 0 &&
                    roomDetailDto.getPrice() ==0 &&
                    roomDetailDto.getCapacity() ==0 &&
                    roomDetailDto.getDistrictId() ==0 &&
                    roomDetailDto.getWardId() ==0){
                list = roomService.findMultiSearch( roomDetailDto.getUserId(), roomDetailDto.getProvinceId(),
                        roomDetailDto.getPrice(), roomDetailDto.getCapacity());
            }
            else if(roomDetailDto.getUserId() == null &&
                    roomDetailDto.getProvinceId() != 0 &&
                    roomDetailDto.getPrice() ==0 &&
                    roomDetailDto.getCapacity() ==0 &&
                    roomDetailDto.getDistrictId() ==0 &&
                    roomDetailDto.getWardId() ==0){
                list = roomService.findMultiSearch( roomDetailDto.getUserId(), roomDetailDto.getProvinceId(),
                        roomDetailDto.getPrice(), roomDetailDto.getCapacity());
            }
            else if(roomDetailDto.getUserId() == null &&
                    roomDetailDto.getProvinceId() == 0 &&
                    roomDetailDto.getPrice() !=0 &&
                    roomDetailDto.getCapacity() ==0 &&
                    roomDetailDto.getDistrictId() ==0 &&
                    roomDetailDto.getWardId() ==0){
                list = roomService.findMultiSearch( roomDetailDto.getUserId(), roomDetailDto.getProvinceId(),
                        roomDetailDto.getPrice(), roomDetailDto.getCapacity());
            }
            else if(roomDetailDto.getUserId() == null &&
                    roomDetailDto.getProvinceId() == 0 &&
                    roomDetailDto.getPrice() ==0 &&
                    roomDetailDto.getCapacity() !=0 &&
                    roomDetailDto.getDistrictId() ==0 &&
                    roomDetailDto.getWardId() ==0){
                list = roomService.findMultiSearch( roomDetailDto.getUserId(), roomDetailDto.getProvinceId(),
                        roomDetailDto.getPrice(), roomDetailDto.getCapacity());
            }
            /**
             * Multi Search 2 Filter
             */
            else if (roomDetailDto.getProvinceId() !=0 && roomDetailDto.getDistrictId() !=0 &&
                    roomDetailDto.getPrice() ==0 && roomDetailDto.getWardId() == 0 &&roomDetailDto.getCapacity() ==0){
                list = roomService.findMultiSearchs( roomDetailDto.getPrice(), roomDetailDto.getCapacity(),
                        roomDetailDto.getProvinceId(), roomDetailDto.getDistrictId());
            }
            else if (roomDetailDto.getProvinceId() ==0 && roomDetailDto.getDistrictId() ==0 &&
                    roomDetailDto.getPrice() !=0 && roomDetailDto.getWardId() == 0 &&roomDetailDto.getCapacity() !=0){
                list = roomService.findMultiSearchs( roomDetailDto.getPrice(), roomDetailDto.getCapacity(),
                        roomDetailDto.getProvinceId(), roomDetailDto.getDistrictId());
            }
            else if (roomDetailDto.getProvinceId() !=0 && roomDetailDto.getPrice() !=0 &&
                    roomDetailDto.getDistrictId() ==0 && roomDetailDto.getCapacity() ==0 &&
                    roomDetailDto.getWardId() ==0){
                list = roomService.findMultiSearch2Filter( roomDetailDto.getProvinceId(),roomDetailDto.getPrice());
            }
            else if (roomDetailDto.getProvinceId() !=0 && roomDetailDto.getPrice() ==0 &&
                    roomDetailDto.getDistrictId() ==0 && roomDetailDto.getCapacity() !=0 &&
                    roomDetailDto.getWardId() ==0){
                list = roomService.findMultiSearch2Filters( roomDetailDto.getProvinceId(),roomDetailDto.getCapacity());
            }
            /**
             * Multi Search 3 Filter
             */
            else if (roomDetailDto.getProvinceId() !=0 && roomDetailDto.getPrice() ==0 &&
                    roomDetailDto.getDistrictId() !=0 && roomDetailDto.getCapacity() ==0 &&
                    roomDetailDto.getWardId() !=0){
                list = roomService.findMultiSearch3Filters( roomDetailDto.getProvinceId(), roomDetailDto.getDistrictId(),
                        roomDetailDto.getWardId(), roomDetailDto.getPrice(), roomDetailDto.getCapacity());
            }
            else if (roomDetailDto.getProvinceId() !=0 && roomDetailDto.getPrice() ==0 &&
                    roomDetailDto.getDistrictId() !=0 && roomDetailDto.getCapacity() !=0 &&
                    roomDetailDto.getWardId() ==0){
                list = roomService.findMultiSearch3Filters( roomDetailDto.getProvinceId(), roomDetailDto.getDistrictId(),
                        roomDetailDto.getWardId(), roomDetailDto.getPrice(), roomDetailDto.getCapacity());
            }
            else if (roomDetailDto.getProvinceId() !=0 && roomDetailDto.getPrice() !=0 &&
                    roomDetailDto.getDistrictId() !=0 && roomDetailDto.getCapacity() ==0 &&
                    roomDetailDto.getWardId() ==0){
                list = roomService.findMultiSearch3Filters( roomDetailDto.getProvinceId(), roomDetailDto.getDistrictId(),
                        roomDetailDto.getWardId(), roomDetailDto.getPrice(), roomDetailDto.getCapacity());
            }
            else if (roomDetailDto.getProvinceId() !=0 && roomDetailDto.getPrice() !=0 &&
                    roomDetailDto.getDistrictId() ==0 && roomDetailDto.getCapacity() !=0 &&
                    roomDetailDto.getWardId() ==0){
                list = roomService.findMultiSearch3Filters( roomDetailDto.getProvinceId(), roomDetailDto.getDistrictId(),
                        roomDetailDto.getWardId(), roomDetailDto.getPrice(), roomDetailDto.getCapacity());
            }
            /**
             * Multi Search 4 Filter
             */
            else if (roomDetailDto.getProvinceId() !=0 && roomDetailDto.getPrice() !=0 &&
                    roomDetailDto.getDistrictId() !=0 && roomDetailDto.getCapacity() ==0 &&
                    roomDetailDto.getWardId() !=0){
                list = roomService.findMultiSearch4Filters( roomDetailDto.getProvinceId(), roomDetailDto.getDistrictId(),
                        roomDetailDto.getWardId(), roomDetailDto.getPrice(), roomDetailDto.getCapacity());
            }
            else if (roomDetailDto.getProvinceId() !=0 && roomDetailDto.getPrice() ==0 &&
                    roomDetailDto.getDistrictId() !=0 && roomDetailDto.getCapacity() !=0 &&
                    roomDetailDto.getWardId() !=0){
                list = roomService.findMultiSearch4Filters( roomDetailDto.getProvinceId(), roomDetailDto.getDistrictId(),
                        roomDetailDto.getWardId(), roomDetailDto.getPrice(), roomDetailDto.getCapacity());
            }
            else if (roomDetailDto.getProvinceId() !=0 && roomDetailDto.getPrice() !=0 &&
                    roomDetailDto.getDistrictId() !=0 && roomDetailDto.getCapacity() !=0 &&
                    roomDetailDto.getWardId() ==0){
                list = roomService.findMultiSearch4Filters( roomDetailDto.getProvinceId(), roomDetailDto.getDistrictId(),
                        roomDetailDto.getWardId(), roomDetailDto.getPrice(), roomDetailDto.getCapacity());
            }
            /**
             * Multi Search 5 Filter
             */
            else if (roomDetailDto.getProvinceId() !=0 && roomDetailDto.getPrice() !=0 &&
                    roomDetailDto.getDistrictId() !=0 && roomDetailDto.getCapacity() !=0 &&
                    roomDetailDto.getWardId() !=0){
                list = roomService.findMultiSearch5Filters( roomDetailDto.getProvinceId(), roomDetailDto.getDistrictId(),
                        roomDetailDto.getWardId(), roomDetailDto.getPrice(), roomDetailDto.getCapacity());
            }
        }
        return list;

    }
}
