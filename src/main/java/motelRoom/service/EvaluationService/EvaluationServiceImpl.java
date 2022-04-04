package motelRoom.service.EvaluationService;

import motelRoom.dto.valuation.EvaluationCreateDto;
import motelRoom.dto.valuation.EvaluationDetailDto;
import motelRoom.entity.EvaluationEntity;
import motelRoom.mapper.EvaluationMapper;
import motelRoom.repository.EvaluationRepository;
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
        return  evaluationMapper.fromEntityToDetailDto(evaluationRepository.getById(id));

     }

     // get all
    @Override
    public List<EvaluationDetailDto> findAll() {
     return evaluationMapper.fromEntitiesToDto(evaluationRepository.findAll());
    }

    //delete
    @Override
    public void deleteById(UUID id) {
        evaluationRepository.deleteById(id);
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
