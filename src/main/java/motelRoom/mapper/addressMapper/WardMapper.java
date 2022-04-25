package motelRoom.mapper.addressMapper;

import motelRoom.dto.address.ward.WardDetailDto;
import motelRoom.entity.addressEntity.WardEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface WardMapper {
    WardDetailDto fromEntityToDetailDto(WardEntity wardEntity);
    List<WardDetailDto> fromEntitiesToDtos(List<WardEntity> wardEntities);
}
