package com.grm.documentation.services.interfaces;

import com.grm.documentation.models.dto.ParagraphDTO;
import com.grm.documentation.models.entities.Paragraph;

import java.util.List;

public interface IParagraphService {

    List<Paragraph> findAll();
    Paragraph findById(Long id);
    Paragraph save(Paragraph paragraph);
    void deleteById(Long id);

    List<ParagraphDTO> getAllParagraphs();
}
