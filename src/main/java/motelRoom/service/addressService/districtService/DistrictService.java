package motelRoom.service.addressService.districtService;

import motelRoom.dto.address.district.DistrictDetailDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DistrictService {
    List<DistrictDetailDto> findAll();
    DistrictDetailDto findById(Integer id);
}
