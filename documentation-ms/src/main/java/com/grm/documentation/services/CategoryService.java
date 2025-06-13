package com.grm.documentation.services;

import com.grm.documentation.models.dto.CategoryAllDTO;
import com.grm.documentation.models.dto.CategoryAndTopicDTO;
import com.grm.documentation.models.entities.Category;
import com.grm.documentation.repositories.CategoryRepository;
import com.grm.documentation.services.interfaces.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Topic not found with id: " + id));
    }

    @Override
    @Transactional
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryAndTopicDTO> getAllCategoriesAndTopics() {
        return categoryRepository.findAll().stream()
                .map(CategoryAndTopicDTO::fromEntity)
                .toList();
    }

    @Override
    public List<CategoryAndTopicDTO> findCategoryAndTopicsBySectionId(Long id) {
        return categoryRepository.findCategoryAndTopicsBySectionId(id).stream()
                .map(CategoryAndTopicDTO::fromEntity)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryAllDTO> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(CategoryAllDTO::fromEntity)
                .toList();
    }
}
