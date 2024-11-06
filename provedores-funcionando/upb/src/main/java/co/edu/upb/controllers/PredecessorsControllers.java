
/* 
package co.edu.upb.controllers;


import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.upb.dto.ApiResponse;
import co.edu.upb.entities.Predecessors;
import co.edu.upb.services.PredecessorsService;
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
@RestController
public class PredecessorsControllers {

    private final PredecessorsService predecessorsService;

    public PredecessorsControllers(PredecessorsService predecessorsService) {
        this.predecessorsService = predecessorsService;
    }
    
    @GetMapping("/predecessor/{id}")
    public ApiResponse<Predecessors> getPredecessorsById(@PathVariable long id) {
        Optional<Predecessors> optionalPredecessors = predecessorsService.getPredecessorsById(id);
        
        if (optionalPredecessors.isPresent()) {
            return new ApiResponse<>(optionalPredecessors.get(), "Proveedor encontrado");
        } else {
            return new ApiResponse<>(null, "Proveedor no encontrado");
        }
    }
    


// @PostMapping("/suppliers/{id}/evaluations")
// public ApiResponse<Evaluation> addEvaluationToSupplier(@PathVariable long id, @RequestBody Evaluation evaluation) {
//     Evaluation savedEvaluation = suppliersServices.addEvaluationToSupplier(id, evaluation);
//     System.out.println("Evaluation received: " + evaluation); // Para depuración
//     if (savedEvaluation != null) {
//         return new ApiResponse<>(savedEvaluation, true, "Evaluación agregada con éxito");
//     } else {
//         return new ApiResponse<>(null, false, "No se pudo agregar la evaluación. Proveedor no encontrado.");
//     }
// }


}
*/