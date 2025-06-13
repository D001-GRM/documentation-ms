package com.grm.documentation.controllers;

import com.grm.documentation.models.dto.CategoryAllDTO;
import com.grm.documentation.models.dto.CategoryAndTopicDTO;
import com.grm.documentation.services.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "https://grm.whocky.com")
@RestController
@RequestMapping("/documentation/categories")
public class CategoryCtrl {
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryCtrl.class);
    private final CategoryService categoryService;

    @Autowired
    public CategoryCtrl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories-and-topics")
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryAndTopicDTO> getAllCategoriesAndTopics() {
        LOGGER.info("getAllCategoriesAndTopics");
        return categoryService.getAllCategoriesAndTopics();
    }

    @GetMapping("/categories-and-topics/{sectionId}")
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryAndTopicDTO> findCategoryAndTopicsBySectionId(@PathVariable Long sectionId) {
        LOGGER.info("findCategoryAndTopicsBySectionId");
        return categoryService.findCategoryAndTopicsBySectionId(sectionId);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryAllDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }
}
