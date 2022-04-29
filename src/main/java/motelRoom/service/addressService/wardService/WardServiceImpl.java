package motelRoom.service.addressService.wardService;

import motelRoom.dto.address.ward.WardDetailDto;
import motelRoom.service.exceptionService.NotAcceptable;
import motelRoom.mapper.addressMapper.WardMapper;
import motelRoom.repository.addressRepository.WardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WardServiceImpl implements WardService{
    private final WardRepository wardRepository;
    private final WardMapper wardMapper;

    public WardServiceImpl(WardRepository wardRepository, WardMapper wardMapper) {
        this.wardRepository = wardRepository;
        this.wardMapper = wardMapper;
    }

    /**
     * Show list ward
     * @return
     */
    public List<WardDetailDto> findAll(){
        return wardMapper.fromEntitiesToDtos(wardRepository.findAll());
    }

    /**
     * Show ward by id
     * @param id
     * @return
     */
    public WardDetailDto findById(Integer id){

        if(wardRepository.existsById(id))
        {
            return  wardMapper.fromEntityToDetailDto(wardRepository.getById(id));
        }
        else {
            throw new NotAcceptable("can't find ward with id: " + id);
        }
    }
}