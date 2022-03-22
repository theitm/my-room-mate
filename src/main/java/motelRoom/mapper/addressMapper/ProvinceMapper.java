package motelRoom.mapper.addressMapper;

import motelRoom.dto.address.province.ProvinceCreateDto;
import motelRoom.dto.address.province.ProvinceDetailDto;
import motelRoom.entity.addressEntity.ProvinceEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ProvinceMapper {
    ProvinceEntity fromProvinceCreateDto(ProvinceCreateDto provinceCreateDto);

    ProvinceDetailDto fromEntityToDetailDto(ProvinceEntity provinceEntity);

    List<ProvinceDetailDto> fromEntityToDto(List<ProvinceEntity> provinceEntities);
}
