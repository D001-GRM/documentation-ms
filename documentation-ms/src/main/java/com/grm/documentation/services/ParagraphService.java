package com.grm.documentation.services;

import com.grm.documentation.models.dto.ParagraphDTO;
import com.grm.documentation.models.entities.Paragraph;
import com.grm.documentation.repositories.ParagraphRepository;
import com.grm.documentation.services.interfaces.IParagraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ParagraphService implements IParagraphService {

    private final ParagraphRepository paragraphRepository;

    @Autowired
    public ParagraphService(ParagraphRepository paragraphRepository) {
        this.paragraphRepository = paragraphRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Paragraph> findAll() {
        return paragraphRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Paragraph findById(Long id) {
        return paragraphRepository.findById(id).orElseThrow(() -> new RuntimeException("Paragraph not found with id: " + id));
    }

    @Override
    @Transactional
    public Paragraph save(Paragraph paragraph) {
        return paragraphRepository.save(paragraph);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        paragraphRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ParagraphDTO> getAllParagraphs() {
        return paragraphRepository.findAll().stream()
                .map(ParagraphDTO::fromEntity)
                .toList();
    }
}
