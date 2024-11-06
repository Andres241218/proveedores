package co.edu.upb.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.upb.dto.ApiResponse;
import co.edu.upb.entities.Question;
import co.edu.upb.services.QuestionsService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class QuestionsControllers {

    private final QuestionsService QuestionsService;

    public QuestionsControllers(QuestionsService QuestionsService) {
        this.QuestionsService = QuestionsService;
    }


    @GetMapping("/questions")
    public ApiResponse<List<Question>> getAllQuestions() {
        List<Question> Questions = QuestionsService.getAllQuestions();
        return new ApiResponse<>(Questions, "Lista de preguntas obtenida con éxito");
    }
    
    @GetMapping("/questions/{id}")
    public ApiResponse<Question> getQuestionsById(@PathVariable long id) {
        Optional<Question>  Questions = QuestionsService.getQuestionsById(id);
        if (Questions != null) {
            return new ApiResponse<>(Questions.get(), "Pregunta encontrada");
        } else {
            return new ApiResponse<>(null, "Pregunta no encontrada");
        }
    }

}
