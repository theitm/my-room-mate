package motelRoom.service.documentService;

import motelRoom.dto.document.DocumentCreateDto;
import motelRoom.dto.document.DocumentDetailDto;
import motelRoom.entity.DocumentEntity;

import java.util.List;
import java.util.UUID;

public interface DocumentService {


    DocumentDetailDto createDocument(DocumentCreateDto documentCreateDto);
    List<DocumentDetailDto> findAll();



    DocumentDetailDto updateDocument(UUID id, DocumentCreateDto documentCreateDto);
    void deleteById(UUID id);

    List<DocumentDetailDto> finAllRoomId(String room_id);


}
