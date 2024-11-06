package co.edu.upb.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import co.edu.upb.dto.ApiResponse;
import co.edu.upb.entities.Evaluation;
import co.edu.upb.entities.Suppliers;
import co.edu.upb.services.SuppliersServices;
//Adicionar a los controladores para que reciba peticiones de el Front
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class SuppliersController {

    private final SuppliersServices suppliersServices;

    public SuppliersController(SuppliersServices suppliersServices) {
        this.suppliersServices = suppliersServices;
    }

    @GetMapping("/suppliers")
    public ApiResponse<List<Suppliers>> getAllSuppliers() {
        List<Suppliers> suppliers = suppliersServices.getAllSuppliers();
        return new ApiResponse<>(suppliers,  "Lista de proveedores obtenida con éxito");
    }

    @GetMapping("/suppliers/{id}")
    public ApiResponse<Suppliers> getSupplierById(@PathVariable long id) {
        Suppliers supplier = suppliersServices.getSupplierById(id);
        if (supplier != null) {
            return new ApiResponse<>(supplier,  "Proveedor encontrado");
        } else {
            return new ApiResponse<>(null, "Proveedor no encontrado");
        }
    }

    @PostMapping("/suppliers")
    public ApiResponse<Suppliers> addSupplier(@RequestBody Suppliers supplier) {
        Suppliers savedSupplier = suppliersServices.addSupplier(supplier);
        
        if (savedSupplier == null) {
            return new ApiResponse<>(null,  "Ya existe un proveedor con el mismo ID");
        }
        
        return new ApiResponse<>(savedSupplier,  "Proveedor agregado con éxito");
    }

    
    @GetMapping("/suppliers/search")
    public ApiResponse<Suppliers> getSupplierByNameOrNit(@RequestParam String nameOrNit) {
        Suppliers supplier = suppliersServices.findSupplierByNameOrNit(nameOrNit);
        if (supplier != null) {
            return new ApiResponse<>(supplier,  "Proveedor encontrado");
        } else {
            return new ApiResponse<>(null,  "Proveedor no encontrado");
        }
    }


    @PostMapping("/suppliers/{id}/evaluations")
    public ApiResponse<Evaluation> addEvaluationToSupplier(@PathVariable long id, @RequestBody Evaluation evaluation) {
        Evaluation savedEvaluation = suppliersServices.addEvaluationToSupplier(id, evaluation);
        
        if (savedEvaluation != null) {
            return new ApiResponse<>(savedEvaluation,  "Evaluación agregada con éxito");
        } else {
            return new ApiResponse<>(null, "No se pudo agregar la evaluación. Proveedor no encontrado.");
        }
    }
}
