package motelRoom.service.EvaluationService;

import motelRoom.dto.valuation.EvaluationCreateDto;
import motelRoom.dto.valuation.EvaluationDetailDto;

import java.util.List;
import java.util.UUID;

public interface EvaluationService {

    EvaluationDetailDto createEvaluation(EvaluationCreateDto evaluationCreateDto);
    EvaluationDetailDto findById(UUID id) ;

    List<EvaluationDetailDto> findAll();

    EvaluationDetailDto updateEvaluation(UUID id, EvaluationCreateDto evaluationCreateDto);
    void deleteById(UUID id);

}
