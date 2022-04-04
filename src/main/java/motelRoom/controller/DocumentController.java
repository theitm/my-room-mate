package motelRoom.controller;
import motelRoom.dto.document.DocumentCreateDto;
import motelRoom.dto.document.DocumentDetailDto;
import motelRoom.repository.DocumentRepository;
import motelRoom.service.documentService.DocumentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping(value = "/Document")
public class DocumentController {
    private final DocumentService documentService;
    public DocumentController(DocumentService documentService, DocumentRepository repository) {
        this.documentService = documentService;
    }
    /**.....get all document...........**/
    @GetMapping
    public List<DocumentDetailDto> findAll(){

        return documentService.findAll();
    }
    /**.....get all by id document...........**/
    @GetMapping("/{room_id}")
    public List<DocumentDetailDto> findById(@PathVariable UUID room_id){
        return (documentService.finAllRoomId(room_id));
    }
    /**.....post document...........**/
    @PostMapping
    public ResponseEntity<DocumentDetailDto> createDocument(@RequestBody DocumentCreateDto documentCreateDto){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(documentService.createDocument(documentCreateDto));
    }
    /**.....put document...........**/
    @PutMapping("/{id}")
    public void update(@RequestBody DocumentCreateDto documentCreateDto, @PathVariable UUID id) {
        documentService.saveUpdate(id ,documentCreateDto);
    }
    /**.....delete document...........**/
    @DeleteMapping("/delete/{id}")
    public String  deleteDocument(@PathVariable(name = "id") UUID id){
        documentService.deleteById(id);
        return "Xoa thanh cong: " +id;
    }
}
