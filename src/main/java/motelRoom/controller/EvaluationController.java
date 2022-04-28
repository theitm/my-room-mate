package motelRoom.controller;

import motelRoom.dto.evaluation.EvaluationCreateDto;
import motelRoom.dto.evaluation.EvaluationDetailDto;
import motelRoom.service.evaluationService.EvaluationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/evaluation")
public class EvaluationController{
    @Autowired
    private final EvaluationServiceImpl evaluationService;

    public EvaluationController(EvaluationServiceImpl evaluationService) {

        this.evaluationService = evaluationService;
    }

    /**.....get all id evaluation...........**/
    @GetMapping("/{id}")
    public ResponseEntity<EvaluationDetailDto> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(evaluationService.findById(id));
    }

    /**.....get all evaluation...........**/
    @GetMapping
    public List<EvaluationDetailDto> findAll(){

        return evaluationService.findAll();
    }

    /**.....post evaluation...........**/
    @PostMapping
    public ResponseEntity<EvaluationDetailDto> create(@RequestBody EvaluationCreateDto createDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(evaluationService.createEvaluation(createDto));
    }

    /**......delete evaluation....**/
    @DeleteMapping("{id}")
    public ResponseEntity deleteById(@PathVariable UUID id){
        evaluationService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    /**.........update evaluation....**/
    @PutMapping("/{id}")
    public void update(@RequestBody EvaluationCreateDto evaluationCreateDto, @PathVariable UUID id) {
        evaluationService.saveUpdate(id ,evaluationCreateDto);
    }
}

