package motelRoom.service.EvaluationService;

import motelRoom.dto.valuation.EvaluationCreateDto;
import motelRoom.dto.valuation.EvaluationDetailDto;
import motelRoom.mapper.EvaluationMapper;
import motelRoom.repository.EvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EvaluationServiceImpl implements EvaluationService{
    @Autowired
    private final EvaluationRepository evaluationRepository;
    @Autowired
    private final motelRoom.mapper.EvaluationMapper EvaluationMapper;

    public EvaluationServiceImpl(EvaluationRepository evaluatitonRepository, EvaluationMapper evaluationMapper, EvaluationRepository evaluationRepository, EvaluationMapper evaluationMapper1){
        this.evaluationRepository = evaluationRepository;
        this.EvaluationMapper = evaluationMapper;


    }

    @Override
    public EvaluationDetailDto createEvaluation(EvaluationCreateDto createDto) {
        return null;
    }

    @Override
    public EvaluationDetailDto findById(UUID id) {
        return null;
    }

    @Override
    public List<EvaluationDetailDto> findById() {
        return null;
    }

    @Override
    public EvaluationDetailDto UpdateEvaluation(UUID id, EvaluationCreateDto evaluationCreateDto) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }
}
