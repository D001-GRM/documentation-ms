package com.grm.documentation.services.interfaces;

import com.grm.documentation.models.dto.SectionAllDTO;
import com.grm.documentation.models.dto.SectionNameDTO;
import com.grm.documentation.models.entities.Section;

import java.util.List;

public interface ISectionService {

    List<Section> findAll();
    SectionNameDTO findById(Long id);
    Section save(Section section);
    void deleteById(Long id);

    List<SectionNameDTO> getAllSectionNames();
    List<SectionAllDTO> getAllSections();
}
