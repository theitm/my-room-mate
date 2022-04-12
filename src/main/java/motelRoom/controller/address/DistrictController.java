package motelRoom.controller.address;

import motelRoom.dto.address.district.DistrictDetailDto;
import motelRoom.service.exceptionService.BadRequestException;
import motelRoom.service.addressService.districtService.DistrictService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/district")
public class DistrictController {
    private final DistrictService districtService;

    public DistrictController(DistrictService districtService) {
        this.districtService = districtService;
    }

    /** GET ALL DISTRICT **/
    @GetMapping
    public List<DistrictDetailDto> findAll()
    {
        return districtService.findAll();
    }

    /** GET DISTRICT BY ID **/
    @GetMapping("/{id}")
    public ResponseEntity<DistrictDetailDto> findById(@PathVariable Integer id){
            return ResponseEntity.ok(districtService.findById(id));
    }
}
