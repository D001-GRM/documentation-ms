package com.grm.documentation.repositories;

import com.grm.documentation.models.entities.Paragraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParagraphRepository extends JpaRepository<Paragraph, Long> {
}
