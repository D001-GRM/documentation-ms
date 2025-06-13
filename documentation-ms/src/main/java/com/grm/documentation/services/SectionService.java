package com.grm.documentation.services;

import com.grm.documentation.models.dto.SectionAllDTO;
import com.grm.documentation.models.dto.SectionNameDTO;
import com.grm.documentation.models.entities.Section;
import com.grm.documentation.repositories.SectionRepository;
import com.grm.documentation.services.interfaces.ISectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SectionService implements ISectionService {

    private final SectionRepository sectionRepository;

    @Autowired
    public SectionService(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Section> findAll() {
        return sectionRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public SectionNameDTO findById(Long id) {
        Section item = sectionRepository.findById(id).orElseThrow(() -> new RuntimeException("Section not found with id: " + id));
        return SectionNameDTO.fromEntity(item);
    }

    @Override
    @Transactional
    public Section save(Section section) {
        return sectionRepository.save(section);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        sectionRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SectionNameDTO> getAllSectionNames() {
        return sectionRepository.findAll().stream()
                .map(SectionNameDTO::fromEntity)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<SectionAllDTO> getAllSections() {
        return sectionRepository.findAll().stream()
                .map(SectionAllDTO::fromEntity)
                .toList();
    }
}
