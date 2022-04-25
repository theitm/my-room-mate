package motelRoom.service.documentService;

import motelRoom.dto.document.DocumentCreateDto;
import motelRoom.dto.document.DocumentDetailDto;
import motelRoom.dto.room.RoomDetailDto;

import java.util.List;
import java.util.UUID;

public interface DocumentService {
    DocumentDetailDto createDocument(DocumentCreateDto documentCreateDto);
    List<DocumentDetailDto> findAll();
    List<DocumentDetailDto> findById(UUID parentId);
    void deleteById(UUID id);
    DocumentDetailDto saveUpdate(UUID id, DocumentCreateDto createDto);
}
