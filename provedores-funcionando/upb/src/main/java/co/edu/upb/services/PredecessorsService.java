/*package co.edu.upb.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import co.edu.upb.entities.Predecessors;
import co.edu.upb.repository.EvaluationRepository;
import co.edu.upb.repository.PredecessorsRepository;


@Service
public class PredecessorsService {

    private final PredecessorsRepository PredecessorsRepository;
    private final EvaluationRepository evaluationRepository;

    public PredecessorsService(PredecessorsRepository PredecessorsRepository, EvaluationRepository evaluationRepository) {
        this.PredecessorsRepository = PredecessorsRepository;
        this.evaluationRepository = evaluationRepository;
    }

    public Optional<Predecessors> getPredecessorsById(long id) {
        return PredecessorsRepository.findById(id);
    }


    // public Evaluation addEvaluationToSupplier(long supplierId, Evaluation evaluation) {
    // Suppliers supplier = suppliersRepository.findById(supplierId);
    // if (supplier != null) {
    //     // Añadir la evaluación a la lista de evaluaciones del proveedor
    //     supplier.getEvaluation().add(evaluation);
        
    //     // Guardar cambios en el repositorio
    //     suppliersRepository.save(supplier);
        
    //     // Guardar evaluación en el repositorio de evaluaciones
    //     evaluationRepository.save(evaluation);
        
    //     return evaluation;
    // } else {
    //     return null; // El proveedor no fue encontrado
    // }

}
*/