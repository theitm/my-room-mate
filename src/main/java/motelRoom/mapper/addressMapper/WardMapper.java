package motelRoom.mapper.addressMapper;

import motelRoom.dto.address.ward.WardCreateDto;
import motelRoom.dto.address.ward.WardDetailDto;
import motelRoom.entity.addressEntity.WardEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface WardMapper {
    WardEntity fromWardCreateDto(WardCreateDto wardCreateDto);

    WardDetailDto fromEntityToDetailDto(WardEntity wardEntity);

    List<WardDetailDto> fromEntityToDto(List<WardEntity> wardEntities);
}
