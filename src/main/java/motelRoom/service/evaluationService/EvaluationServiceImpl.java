package motelRoom.service.evaluationService;

import motelRoom.dto.evaluation.EvaluationCreateDto;
import motelRoom.dto.evaluation.EvaluationDetailDto;
import motelRoom.entity.EvaluationEntity;
import motelRoom.mapper.EvaluationMapper;
import motelRoom.repository.EvaluationRepository;
import motelRoom.service.exceptionService.NotAcceptable;
import motelRoom.service.exceptionService.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EvaluationServiceImpl implements EvaluationService{
    private final EvaluationRepository evaluationRepository;
    private final EvaluationMapper evaluationMapper;

    public EvaluationServiceImpl(EvaluationRepository evaluationRepository, EvaluationMapper evaluationMapper){
        this.evaluationRepository=evaluationRepository;
        this.evaluationMapper=evaluationMapper;
    }

    /**
     * create evaluation
     * @param evaluationCreateDto
     * @return
     */
    @Override
    public EvaluationDetailDto createEvaluation(EvaluationCreateDto evaluationCreateDto) {
        UUID user = evaluationCreateDto.getUserId();
        UUID room = evaluationCreateDto.getRoomId();
        if (user == null || room == null) {
            throw new NotAcceptable("Please enter information");
        } else {
            EvaluationEntity evaluationEntity = evaluationMapper.fromEvaluationCreateDto(evaluationCreateDto);
            EvaluationEntity evaluationEntityCreate = evaluationRepository.save(evaluationEntity);
            EvaluationDetailDto evaluationDetailDto = null;
            if (evaluationEntityCreate != null) {
                evaluationDetailDto = evaluationMapper.fromEntityToDetailDto(evaluationEntity);

            }
            return evaluationDetailDto;
        }
    }

    /**
     * Show evaluation by id
     * @param id
     * @return
     */
    @Override
    public EvaluationDetailDto findById(UUID id) {
        try{
            EvaluationDetailDto evaluationDetailDto = evaluationMapper.fromEntityToDetailDto(evaluationRepository.getById(id));
            return evaluationDetailDto;
        }
        catch (Exception e){
            throw new NotAcceptable("Can't find evaluation with id: " + id);
        }
     }

    /**
     * Show list evaluation
     * @return
     */
    @Override
    public List<EvaluationDetailDto> findAll() {
     return evaluationMapper.fromEntitiesToDto(evaluationRepository.findAll());
    }

    /**
     * Delete evaluation by id
     * @param id
     * @return
     */
    @Override
    public void deleteById(UUID id) {
        try{
            evaluationRepository.deleteById(id);
        }catch (Exception e){
            throw new NotFoundException("Not find id evaluation");
        }
    }

    /**
     * Update evaluation by id
     * @param id
     * @return
     */
    @Override
    public void saveUpdate(UUID id, EvaluationCreateDto createDto){
        UUID user = createDto.getUserId();
        UUID room = createDto.getRoomId();
        if (user == null || room == null) {
            throw new NotAcceptable("Please enter information");
        } else {
            EvaluationEntity entity = evaluationRepository.findById(id).orElse(null);
            if (entity == null) {
                return;
            }
            BeanUtils.copyProperties(createDto, entity);
            evaluationRepository.saveAndFlush(entity);
        }
    }
}
