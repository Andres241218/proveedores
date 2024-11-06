package co.edu.upb.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.edu.upb.dto.ApiResponse;
import co.edu.upb.entities.Sectional;
import co.edu.upb.services.SectionalService;

@RestController
public class SectionalControllers {

    private final SectionalService SectionalService;

    public SectionalControllers(SectionalService SectionalService) {
        this.SectionalService = SectionalService;
    }


    @GetMapping("/sectionals")
    public ApiResponse<List<Sectional>> getAllSectionals() {
        List<Sectional> Sectionals = SectionalService.getAllSectional();
        return new ApiResponse<>(Sectionals, "Lista de evaluaciones obtenida con éxito");
    }
    
    @GetMapping("/sectionals/{id}")
    public ApiResponse<Sectional> getSectionalsById(@PathVariable long id) {
        Optional<Sectional>  Sectionals = SectionalService.getSectionalsById(id);
        if (Sectionals != null) {
            return new ApiResponse<>(Sectionals.get(), "calificacion encontrada");
        } else {
            return new ApiResponse<>(null, "Proveedor no encontrado");
        }
    }

}
