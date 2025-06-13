package com.grm.documentation.repositories;

import com.grm.documentation.models.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT DISTINCT c FROM Category c LEFT JOIN FETCH c.topics t WHERE c.section.id = :sectionId ORDER BY t.position ASC")
        List<Category> findCategoryAndTopicsBySectionId(@Param("sectionId") Long sectionId);
}
