package motelRoom.mapper.addressMapper;

import motelRoom.dto.address.district.DistrictDetailDto;
import motelRoom.entity.addressEntity.DistrictEntity;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper
public interface DistrictMapper {
    DistrictDetailDto fromEntityToDetailDto(DistrictEntity districtEntity);
    List<DistrictDetailDto> fromEntitiesToDtos(List<DistrictEntity> districtEntities);
}
