package motelRoom.controller;


import motelRoom.dto.document.DocumentCreateDto;
import motelRoom.dto.document.DocumentDetailDto;
import motelRoom.entity.DocumentEntity;
import motelRoom.repository.DocumentRepository;
import motelRoom.service.documentService.DocumentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/Document")
public class DocumentController {

    private final DocumentService documentService;
    private final DocumentRepository repository;

    public DocumentController(DocumentService documentService, DocumentRepository repository) {
        this.documentService = documentService;

        this.repository = repository;
    }

    @GetMapping
    public List<DocumentDetailDto> findAll(){
        return documentService.findAll();
    }

    @PostMapping
    public ResponseEntity<DocumentDetailDto> create(@RequestBody DocumentCreateDto documentCreateDto){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(documentService.createDocument(documentCreateDto));
    }

    @GetMapping("/{room_id}")
    public List<DocumentDetailDto> findById(@PathVariable String room_id){
        return (documentService.finAllRoomId(room_id));
    }


}
