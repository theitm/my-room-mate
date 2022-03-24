package motelRoom.service.documentService;


import motelRoom.dto.document.DocumentCreateDto;
import motelRoom.dto.document.DocumentDetailDto;
import motelRoom.entity.DocumentEntity;
import motelRoom.mapper.DocumentMapper;
import motelRoom.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    private final DocumentRepository documentRepository;
    @Autowired
    private final DocumentMapper mapper;

    public DocumentServiceImpl(DocumentRepository documentRepository, DocumentMapper mapper) {

        this.documentRepository = documentRepository;
        this.mapper = mapper;
    }

    @Override
    public DocumentDetailDto createDocument(DocumentCreateDto documentCreateDto) {
        DocumentEntity documentEntity = mapper.fromDocumentCreateDto(documentCreateDto);
        DocumentEntity documentEntityCreate = documentRepository.save(documentEntity);
        DocumentDetailDto documentDetailDto = null;
        if(documentEntityCreate != null){
            documentDetailDto = mapper.fromEntityToDto(documentEntityCreate);
        }
        return documentDetailDto;
    }


    @Override
    public List<DocumentDetailDto> findAll() {
        return mapper.fromListEntityToDto(documentRepository.findAll());
    }

    @Override
    public DocumentDetailDto updateDocument(UUID id, DocumentCreateDto documentCreateDto) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }

    @Override
    public List<DocumentDetailDto> finAllRoomId(String room_id) {
        return mapper.fromListEntityToDto(documentRepository.myCustomQuery2(room_id));
    }


}
