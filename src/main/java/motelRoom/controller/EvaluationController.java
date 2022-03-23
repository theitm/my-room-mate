package motelRoom.controller;

import motelRoom.dto.valuation.EvaluationCreateDto;
import motelRoom.dto.valuation.EvaluationDetailDto;
import motelRoom.service.EvaluationService.EvaluationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("v1/api/evaluation")
public class EvaluationController {
    private final EvaluationService evaluationService;

    public EvaluationController(EvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }
    @PostMapping
    public ResponseEntity<EvaluationDetailDto> create(@RequestBody EvaluationCreateDto createDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(evaluationService.createEvaluation(createDto));

    }
    @GetMapping("/{id}")
    public ResponseEntity<EvaluationDetailDto > findById(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(evaluationService.findById(id));
    }

    }

