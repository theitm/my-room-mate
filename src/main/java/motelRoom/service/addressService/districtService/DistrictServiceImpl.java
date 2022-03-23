package motelRoom.service.addressService.districtService;

import motelRoom.dto.address.district.DistrictDetailDto;
import motelRoom.mapper.addressMapper.DistrictMapper;
import motelRoom.repository.addressRepository.DistrictRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {
    private final DistrictRepository districtRepository;
    private final DistrictMapper districtMapper;

    public DistrictServiceImpl(DistrictRepository districtRepository, DistrictMapper districtMapper) {
        this.districtRepository = districtRepository;
        this.districtMapper = districtMapper;
    }

    /**
     * Show list districts
     * @return
     */
    public List<DistrictDetailDto> findAll() {return  districtMapper.fromEntityToDto(districtRepository.findAll());}

    /**
     * Show district by id
     * @param id
     * @return
     */
    public DistrictDetailDto findById(Integer id){
        DistrictDetailDto districtDetailDto = districtMapper.fromEntityToDetailDto(districtRepository.getById(id));
        return districtDetailDto;
    }
}
