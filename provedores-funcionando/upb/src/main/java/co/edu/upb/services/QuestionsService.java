package co.edu.upb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import co.edu.upb.entities.Question;
import co.edu.upb.repository.QuestionsRepository;


@Service
public class QuestionsService {

    private final QuestionsRepository questionsRepository;


    public QuestionsService(QuestionsRepository questionsRepository ) {
        this.questionsRepository = questionsRepository;
    }

    public Optional<Question> getQuestionsById(long id) {
        return questionsRepository.findById(id);
    }

    public List<Question> getAllQuestions() {
        return questionsRepository.findAll();
    }

}
