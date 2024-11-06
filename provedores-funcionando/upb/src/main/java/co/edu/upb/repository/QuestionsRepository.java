package co.edu.upb.repository;




import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.upb.entities.Question;


public interface QuestionsRepository  extends JpaRepository<Question, Long>{
}