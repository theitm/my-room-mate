package motelRoom.service.addressService.provinceService;

import motelRoom.dto.address.province.ProvinceDetailDto;
import motelRoom.mapper.addressMapper.ProvinceMapper;
import motelRoom.repository.addressRepository.ProvinceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {
    private  final ProvinceRepository provinceRepository;
    private final ProvinceMapper provinceMapper;

    public ProvinceServiceImpl(ProvinceRepository provinceRepository, ProvinceMapper provinceMapper) {
        this.provinceRepository = provinceRepository;
        this.provinceMapper = provinceMapper;
    }

    /**
     * Show list provinces
     * @return
     */
    public List<ProvinceDetailDto> findAll() {return  provinceMapper.fromEntityToDto(provinceRepository.findAll());}

    /**
     * Show province by id
     * @param id
     * @return
     */
    public ProvinceDetailDto findById(Integer id){
        ProvinceDetailDto provinceDetailDto = provinceMapper.fromEntityToDetailDto(provinceRepository.getById(id));
        return provinceDetailDto;
    }
}
