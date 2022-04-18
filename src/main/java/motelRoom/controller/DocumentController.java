package motelRoom.controller;
import motelRoom.dto.document.DocumentCreateDto;
import motelRoom.dto.document.DocumentDetailDto;
import motelRoom.dto.documentError.ResponseObject;
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
    @GetMapping("/{parentId}")
    public ResponseEntity<ResponseObject> getById(@PathVariable UUID parentId){
        List<DocumentDetailDto> roomID = documentService.findById(parentId);
        if(roomID.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("Failed", "Type ID Name Does Not Exist", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", " Type ID successfully", documentService.findById(parentId))
        );
    }

    /**.....post document...........**/
    @PostMapping
    ResponseEntity<ResponseObject> insertDocument(@RequestBody DocumentCreateDto documentCreateDto) {
        if (documentCreateDto.getParentId() != null && documentCreateDto.getParentType() != 0
                && documentCreateDto.getNameUrl() != null && documentCreateDto.getTypeUrl() != 0)
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "Insert Document Successfully", documentService.createDocument(documentCreateDto))
        );
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                new ResponseObject("Failed", "Document Value Passed Is Empty", ""));
    }

    /**.....put document...........**/
    @PutMapping("/{id}")
     ResponseEntity <ResponseObject> updateDocument(@RequestBody DocumentCreateDto documentCreateDto, @PathVariable UUID id ) {
        Optional<DocumentEntity> createDto = repository.findById(id);
        if (createDto.isPresent() && documentCreateDto.getParentType() < 2 && documentCreateDto.getTypeUrl() < 2) {
            documentService.saveUpdate(id, documentCreateDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("Failed", "Document Value Passed Is Empty", ""));
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok", "PUT Document Successfully", documentCreateDto));
    }

    /**.....delete document...........**/
    @DeleteMapping("/delete/{id}")
    public String deleteDocument(@PathVariable(name = "id") UUID id){
        documentService.deleteById(id);
        return "Delete successfully: " +id;
    }
}
