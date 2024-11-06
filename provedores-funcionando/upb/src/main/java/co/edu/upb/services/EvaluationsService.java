package co.edu.upb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import co.edu.upb.entities.Evaluation;
import co.edu.upb.repository.EvaluationRepository;


@Service
public class EvaluationsService {

    private final EvaluationRepository evaluationRepository;

    public EvaluationsService( EvaluationRepository evaluationRepository) {
        this.evaluationRepository = evaluationRepository;
    }

    public Optional<Evaluation> getEvaluationsById(long id) {
        return evaluationRepository.findById(id);
    }

    public List<Evaluation> getAllEvaluations() {
        return evaluationRepository.findAll();
    }

       public Evaluation addEvaluation(Evaluation evaluation) {
        // Validar si el supplier ya existe usando su ID
        if (evaluationRepository.existsById(evaluation.getId())) {
            return null; // Puedes lanzar una excepción o retornar null para indicar conflicto
        }
        // Guardar el nuevo supplier si el ID no existe
        return evaluationRepository.save(evaluation);

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
