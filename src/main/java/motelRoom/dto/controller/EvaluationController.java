package motelRoom.dto.controller;
import motelRoom.dto.evaluation.EvaluationCreateDto;
import motelRoom.dto.evaluation.EvaluationDetailDto;
import motelRoom.service.EvaluationService.EvaluationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/api/evaluation")
public class EvaluationController {
    @Autowired
    private final EvaluationServiceImpl evaluationService;
    public EvaluationController(EvaluationServiceImpl evaluationService) {
        this.evaluationService = evaluationService;
    }
    /**.....New evaluation.....**/
    @PostMapping
    public ResponseEntity<EvaluationDetailDto> create(@RequestBody EvaluationCreateDto createDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(evaluationService.createEvaluation(createDto));
    }
    /** .....Get evaluation by id.....**/
    @GetMapping("/{id}")
    public ResponseEntity<EvaluationDetailDto> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(evaluationService.findById(id));
    }
    /**.....Get all evaluation.....**/
    @GetMapping
    public List<EvaluationDetailDto> findAll() {
        return evaluationService.findAll();
    }
    /**.....Delete evaluation.....**/
    @DeleteMapping("{id}")
    public ResponseEntity deleteById(@PathVariable UUID id) {
        evaluationService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    /**.....Update evaluation.....**/
    @PutMapping("/{id}")
    public void update(@RequestBody EvaluationCreateDto evaluationCreateDto, @PathVariable UUID id) {
        evaluationService.saveUpdate(id, evaluationCreateDto);
    }
}

