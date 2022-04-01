package motelRoom.service.addressService.provinceService;

import motelRoom.dto.address.province.ProvinceDetailDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProvinceService {
    List<ProvinceDetailDto> findAll();
    ProvinceDetailDto findById(Integer id);
}
