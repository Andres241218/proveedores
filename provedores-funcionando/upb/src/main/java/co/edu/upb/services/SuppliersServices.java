package co.edu.upb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import co.edu.upb.entities.Evaluation;
import co.edu.upb.entities.Suppliers;
import co.edu.upb.repository.EvaluationRepository;
import co.edu.upb.repository.SuppliersRepository;


@Service
public class SuppliersServices {

    private final SuppliersRepository suppliersRepository;
    private final EvaluationRepository evaluationRepository;

   
    public SuppliersServices(SuppliersRepository suppliersRepository, EvaluationRepository evaluationRepository) {
        this.suppliersRepository = suppliersRepository;
        this.evaluationRepository = evaluationRepository;
    }

    public List<Suppliers> getAllSuppliers() {
        return suppliersRepository.findAll();
    }

    public Suppliers getSupplierById(long id) {
        return suppliersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier with ID " + id + " not found."));
    }

    public Suppliers addSupplier(Suppliers supplier) {
        if (suppliersRepository.existsById(supplier.getSuppliersId())) {
            throw new RuntimeException("Supplier with ID " + supplier.getSuppliersId() + " already exists.");
        }
        return suppliersRepository.save(supplier);
    }


    public Suppliers findSupplierByNameOrNit(String nameOrNit) {
        Suppliers supplier = suppliersRepository.findBySuppliersName(nameOrNit);
        if (supplier == null) {
            supplier = suppliersRepository.findBySuppliersNit(nameOrNit);
        }
        return supplier;
    }

    public Evaluation addEvaluationToSupplier(long supplierId, Evaluation evaluation) {
        // Obtener el proveedor por su ID
        Optional<Suppliers> optionalSupplier = suppliersRepository.findById(supplierId);
        
        // Verificar si el proveedor está presente
        if (optionalSupplier.isPresent()) {
            Suppliers supplier = optionalSupplier.get(); // Obtener el proveedor
    
            // Obtener el usuario actual que está evaluando
            //User evaluator = getCurrentUser(); 
            
            // Establecer el evaluador en la evaluación
            //evaluation.setAdministrator(evaluator);
    
            // Asignar el proveedor a la evaluación para mantener la relación bidireccional
            //evaluation.setSupplier(supplier);
            
            // Añadir la evaluación a la lista de evaluaciones del proveedor
            supplier.addEvaluation(evaluation);
    
            // Guardar la evaluación en el repositorio de evaluaciones (propaga el guardado en cascada si está configurado)
            evaluationRepository.save(evaluation);
    
            // Guardar cambios en el repositorio de proveedores
            suppliersRepository.save(supplier);
            
            return evaluation;
        } else {
            throw new RuntimeException("Supplier with ID " + supplierId + " not found.");
        }
    }
        
    
}

