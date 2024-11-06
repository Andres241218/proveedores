package co.edu.upb.repository;




import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.upb.entities.Category;


public interface categoryRepository extends JpaRepository<Category, Long> {
}