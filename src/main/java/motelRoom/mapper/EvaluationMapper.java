package motelRoom.mapper;

import motelRoom.dto.valuation.EvaluationCreateDto;
import motelRoom.dto.valuation.EvaluationDetailDto;
import motelRoom.entity.EvaluationEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface EvaluationMapper {

    EvaluationEntity fromEvaluationCreateDto(EvaluationCreateDto evaluationCreateDto);
    EvaluationDetailDto fromEntityToDetailDto(EvaluationEntity evaluationEntity);
    List<EvaluationDetailDto> fromEntitiesToDto(List<EvaluationEntity> evaluationEntities);


}


