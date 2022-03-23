package motelRoom.mapper;

import motelRoom.dto.valuation.EvaluationCreateDto;
import motelRoom.entity.EvaluationEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface EvaluationMapper {
    EvaluationEntity fromEvaluationCreateDto(EvaluationCreateDto evaluationCreateDto);
    EvaluationCreateDto fromEntityToDetailDto(EvaluationEntity evaluationEntity);
    List<EvaluationCreateDto> fomEntityDto(List<EvaluationEntity> evaluationEntities);

}