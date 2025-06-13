package com.grm.documentation.services.interfaces;

import com.grm.documentation.models.dto.CategoryAllDTO;
import com.grm.documentation.models.dto.CategoryAndTopicDTO;
import com.grm.documentation.models.entities.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> findAll();
    Category findById(Long id);
    Category save(Category category);
    void deleteById(Long id);

    List<CategoryAndTopicDTO> getAllCategoriesAndTopics();
    List<CategoryAndTopicDTO> findCategoryAndTopicsBySectionId(Long id);
    List<CategoryAllDTO> getAllCategories();
}
