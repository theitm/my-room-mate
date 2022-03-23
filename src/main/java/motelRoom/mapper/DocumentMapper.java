package motelRoom.mapper;


import motelRoom.dto.document.DocumentCreateDto;
import motelRoom.dto.document.DocumentDetailDto;
import motelRoom.entity.DocumentEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface DocumentMapper {
    DocumentEntity fromDocumentCreateDto(DocumentCreateDto documentCreateDto);
    DocumentDetailDto fromEntityToDto (DocumentEntity documentEntity);




    List<DocumentDetailDto> fromListEntityToDto(List<DocumentEntity> documentEntities);

}
