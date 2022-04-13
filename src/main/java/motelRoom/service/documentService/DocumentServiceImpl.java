package motelRoom.service.documentService;

import motelRoom.dto.document.DocumentCreateDto;
import motelRoom.dto.document.DocumentDetailDto;
import motelRoom.entity.DocumentEntity;
import motelRoom.mapper.DocumentMapper;
import motelRoom.repository.DocumentRepository;
import motelRoom.service.exceptionService.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
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
    /**.....serviceimpl  create  document...........**/
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
    /**.....serviceimpl  show list all document...........**/
    @Override
    public List<DocumentDetailDto> findAll() {
        return mapper.fromListEntityToDto(documentRepository.findAll());
    }
    /**.....serviceimpl delete by id document...........**/
    @Override
    public void deleteById(UUID id) {
        try {
            documentRepository.deleteById(id);
        }
        catch (Exception e)
        {
            throw new NotFoundException("can't delete document with id: " + id);
        }
    }
    /**.....serviceimpl find by room_id document...........**/
    @Override
    public List<DocumentDetailDto> finAllRoomId(UUID roomId) {
        return mapper.fromListEntityToDto(documentRepository.queryFindByIdRoom(roomId));
    }
    /**.....serviceimpl update by id document...........**/
    @Override
    public DocumentDetailDto saveUpdate(UUID id, DocumentCreateDto createDto) {
        DocumentEntity documentEntity = documentRepository.findById(id).orElse(null);
        if (documentEntity == null) {
            return null;
        }
        BeanUtils.copyProperties(createDto, documentEntity);
        documentRepository.saveAndFlush(documentEntity);
        return mapper.fromEntityToDto(documentEntity);
    }
}
