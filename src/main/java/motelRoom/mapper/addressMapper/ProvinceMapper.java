package motelRoom.mapper.addressMapper;

import motelRoom.dto.address.province.ProvinceDetailDto;
import motelRoom.entity.addressEntity.ProvinceEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ProvinceMapper {
    ProvinceDetailDto fromEntityToDetailDto(ProvinceEntity provinceEntity);
    List<ProvinceDetailDto> fromEntitiesToDtos(List<ProvinceEntity> provinceEntities);
}
