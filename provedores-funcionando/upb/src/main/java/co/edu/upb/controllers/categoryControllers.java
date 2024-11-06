package co.edu.upb.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.upb.dto.ApiResponse;
import co.edu.upb.entities.Category;
import co.edu.upb.services.categoryService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class categoryControllers {

    private final categoryService categoryService;

    public categoryControllers(categoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/category")
    public ApiResponse<List<Category>> getAllcategory() {
        List<Category> category = categoryService.getAllcategory();
        return new ApiResponse<>(category, "Lista de categorias obtenida con éxito");
    }
    
    @GetMapping("/category/{id}")
    public ApiResponse<Category> getcategoryById(@PathVariable long id) {
        Optional<Category>  category = categoryService.getcategorysById(id);
        if (category != null) {
            return new ApiResponse<>(category.get(), "categoria encontrada");
        } else {
            return new ApiResponse<>(null, "categoria no encontrada");
        }
    }

}
