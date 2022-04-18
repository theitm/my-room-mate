package motelRoom.service.documentService;

import motelRoom.dto.document.DocumentCreateDto;
import motelRoom.dto.document.DocumentDetailDto;
import motelRoom.dto.room.RoomDetailDto;

import java.util.List;
import java.util.UUID;

public interface DocumentService {
    /**.....service  create  document...........**/
    DocumentDetailDto createDocument(DocumentCreateDto documentCreateDto);
    /**.....service  show list all document...........**/
    List<DocumentDetailDto> findAll();
    /**.....service  show list allFindById document...........**/
    List<DocumentDetailDto> findById(UUID parentId);
    /**.....service delete by id document...........**/
    void deleteById(UUID id);
    /**.....service update by id document...........**/
    DocumentDetailDto saveUpdate(UUID id, DocumentCreateDto createDto);
}
