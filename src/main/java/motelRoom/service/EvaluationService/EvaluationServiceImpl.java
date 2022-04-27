package motelRoom.service.EvaluationService;

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

    //post
    @Override
    public EvaluationDetailDto createEvaluation(EvaluationCreateDto evaluationCreateDto) {
            EvaluationEntity evaluationEntity = evaluationMapper.fromEvaluationCreateDto(evaluationCreateDto);
            EvaluationEntity evaluationEntityCreate = evaluationRepository.save(evaluationEntity);
            EvaluationDetailDto evaluationDetailDto = null;
            if(evaluationEntityCreate != null){
                evaluationDetailDto = evaluationMapper.fromEntityToDetailDto(evaluationEntity);

            }
            return evaluationDetailDto;
        }

     //get theo id
    @Override
    public EvaluationDetailDto findById(UUID id) {
        try{
            EvaluationDetailDto evaluationDetailDto = evaluationMapper.fromEntityToDetailDto(evaluationRepository.getById(id));
            return evaluationDetailDto;
        }
        catch (Exception e){
            throw new NotAcceptable("Can't find Evaluation with id: " + id);
        }
     }

     // get all
    @Override
    public List<EvaluationDetailDto> findAll() {
     return evaluationMapper.fromEntitiesToDto(evaluationRepository.findAll());
    }

    //delete
    @Override
    public void deleteById(UUID id) {
        try{
            evaluationRepository.deleteById(id);
        }catch (Exception e){
            throw new NotFoundException("Not find id");
        }
    }

    //update
    @Override
    public void saveUpdate(UUID id, EvaluationCreateDto createDto){
        EvaluationEntity entity = evaluationRepository.findById(id).orElse(null);
        if(entity == null){
            return;
        }
        BeanUtils.copyProperties(createDto, entity);
        evaluationRepository.saveAndFlush(entity);
    }
}
