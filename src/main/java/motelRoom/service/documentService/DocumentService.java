package motelRoom.service.documentService;

import motelRoom.dto.document.DocumentCreateDto;
import motelRoom.dto.document.DocumentDetailDto;
import java.util.List;
import java.util.UUID;

public interface DocumentService {
    /**.....service  create  document...........**/
    DocumentDetailDto createDocument(DocumentCreateDto documentCreateDto);
    /**.....service  show list all document...........**/
    List<DocumentDetailDto> findAll();
    /**.....service delete by id document...........**/
    void deleteById(UUID id);
    /**.....service find by typeID document...........**/
    List<DocumentDetailDto> finAllTypeId(UUID typeId);
    /**.....service update by id document...........**/
    DocumentDetailDto saveUpdate(UUID id, DocumentCreateDto createDto);
}
