package motelRoom.mapper;

import motelRoom.dto.sharingDetail.SharingDetailCreateDto;
import motelRoom.dto.sharingDetail.SharingDetailDetailDto;
import motelRoom.entity.SharingDetailEntity;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper
public interface SharingDetailMapper {
    SharingDetailEntity fromSharingDetailCreateDto(SharingDetailCreateDto sharingDetailCreateDto);
    SharingDetailDetailDto fromEntityToDto (SharingDetailEntity sharingDetailEntity);
    List<SharingDetailDetailDto> fromListEntitiesToDtos(List<SharingDetailEntity> sharingDetailEntities);
    SharingDetailEntity fromSharingDetailUpdateDto(SharingDetailDetailDto sharingDetailDetailDto);
}