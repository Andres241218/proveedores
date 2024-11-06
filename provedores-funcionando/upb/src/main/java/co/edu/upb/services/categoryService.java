package co.edu.upb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import co.edu.upb.entities.Category;
import co.edu.upb.repository.categoryRepository;


@Service
public class categoryService {

    private final categoryRepository categoryRepository;


    public categoryService(categoryRepository categoryRepository ) {
        this.categoryRepository = categoryRepository;
    }

    public Optional<Category> getcategorysById(long id) {
        return categoryRepository.findById(id);
    }

    public List<Category> getAllcategory() {
        return categoryRepository.findAll();
    }

}
