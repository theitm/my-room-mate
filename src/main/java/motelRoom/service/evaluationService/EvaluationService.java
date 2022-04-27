package motelRoom.service.evaluationService;

import motelRoom.dto.evaluation.EvaluationCreateDto;
import motelRoom.dto.evaluation.EvaluationDetailDto;

import java.util.List;
import java.util.UUID;

public interface EvaluationService {
    EvaluationDetailDto createEvaluation(EvaluationCreateDto evaluationCreateDto);
    EvaluationDetailDto findById(UUID id) ;
    List<EvaluationDetailDto> findAll();
    void deleteById(UUID id);
    void saveUpdate(UUID id, EvaluationCreateDto createDto);
}
