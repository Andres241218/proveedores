package co.edu.upb.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.upb.dto.ApiResponse;
import co.edu.upb.entities.User;
import co.edu.upb.services.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserControllers {

    private final UserService UserService;

    public UserControllers(UserService UserService) {
        this.UserService = UserService;
    }


    @GetMapping("/users")
    public ApiResponse<List<User>> getAllUsers() {
        List<User> Users = UserService.getAllUser();
        return new ApiResponse<>(Users, "Lista de evaluaciones obtenida con éxito");
    }
    
    @GetMapping("/users/{id}")
    public ApiResponse<User> getUsersById(@PathVariable long id) {
        Optional<User>  Users = UserService.getUsersById(id);
        if (Users != null) {
            return new ApiResponse<>(Users.get(), "calificacion encontrada");
        } else {
            return new ApiResponse<>(null, "Proveedor no encontrado");
        }
    }

}
