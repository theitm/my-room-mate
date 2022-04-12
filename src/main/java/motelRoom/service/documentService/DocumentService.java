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
    /**.....service find by room_id document...........**/
    List<DocumentDetailDto> finAllRoomId(UUID roomId);
    /**.....service update by id document...........**/
    void saveUpdate(UUID id, DocumentCreateDto createDto);
}
