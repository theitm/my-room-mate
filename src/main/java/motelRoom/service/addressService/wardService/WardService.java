package motelRoom.service.addressService.wardService;

import motelRoom.dto.address.ward.WardDetailDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WardService {
    List<WardDetailDto> findAll();
    WardDetailDto findById(Integer id);
}
