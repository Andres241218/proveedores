package co.edu.upb.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.upb.dto.ApiResponse;
import co.edu.upb.entities.Evaluation;
import co.edu.upb.services.EvaluationsService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EvaluationsControllers {

    private final EvaluationsService evaluationsService;

    public EvaluationsControllers(EvaluationsService evaluationsService) {
        this.evaluationsService = evaluationsService;
    }


    @GetMapping("/evaluations")
    public ApiResponse<List<Evaluation>> getAllEvaluations() {
        List<Evaluation> evaluations = evaluationsService.getAllEvaluations();
        return new ApiResponse<>(evaluations, "Lista de evaluaciones obtenida con éxito");
    }
    
    @GetMapping("/evaluations/{id}")
    public ApiResponse<Evaluation> getEvaluationsById(@PathVariable long id) {
        Optional<Evaluation>  evaluations = evaluationsService.getEvaluationsById(id);
        if (evaluations != null) {
            return new ApiResponse<>(evaluations.get(), "Evaluacion encontrada");
        } else {
            return new ApiResponse<>(null, "Evaluacion no encontrado");
        }
    }



}
