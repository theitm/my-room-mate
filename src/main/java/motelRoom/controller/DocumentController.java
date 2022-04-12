package motelRoom.controller;
import motelRoom.dto.document.DocumentCreateDto;
import motelRoom.dto.document.DocumentDetailDto;
import motelRoom.dto.documentError.DocumentError;
import motelRoom.dto.documentError.ResponseObject;
import motelRoom.dto.responseException.ResponseError;
import motelRoom.entity.DocumentEntity;
import motelRoom.repository.DocumentRepository;
import motelRoom.service.documentService.DocumentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@RestController
@RequestMapping(value = "/document")
public class DocumentController {
    private final DocumentService documentService;
    private final DocumentRepository repository;
    public DocumentController(DocumentService documentService, DocumentRepository repository) {
        this.documentService = documentService;
        this.repository = repository;
    }
    /**.....get all document...........**/
    @GetMapping
    public List<DocumentDetailDto> findAll(){
        return documentService.findAll();
    }
    /**.....get all by id document...........**/
    @GetMapping("/{roomId}")
    public ResponseEntity<ResponseObject> getById(@PathVariable UUID roomId){
        List<DocumentDetailDto> roomID = documentService.finAllRoomId(roomId);
        if(roomID.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("Failed", "Room ID Name Does Not Exist", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", " Room ID successfully", documentService.finAllRoomId(roomId))
        );
    }
    /**.....post document...........**/
    @PostMapping
    ResponseEntity<ResponseObject> insertProduct(@RequestBody DocumentCreateDto documentCreateDto) {
        //2 products must not have the same name !
        List<DocumentEntity> foundProducts = repository.finByDocumentURL(documentCreateDto.getRoomUrl().trim());
        if(foundProducts.size() > 0) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("Failed", "Document name already taken", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "Insert Document successfully", documentService.createDocument(documentCreateDto))
        );
    }
    /**.....put document...........**/
    @PutMapping("/{id}")
    public String update(@RequestBody DocumentCreateDto documentCreateDto, @PathVariable UUID id) {
        documentService.saveUpdate(id ,documentCreateDto);
        return "Update successfully: " +id;
    }
    /**.....delete document...........**/
    @DeleteMapping("/delete/{id}")
    public void deleteDocument(@PathVariable(name = "id") UUID id){
        documentService.deleteById(id);
    }
}
