package com.grm.documentation.controllers;

import com.grm.documentation.models.dto.SectionAllDTO;
import com.grm.documentation.models.dto.SectionNameDTO;
import com.grm.documentation.services.SectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("https://grm.whocky.com")
@RestController
@RequestMapping("/documentation/sections")
public class SectionCtrl {
    private static final Logger LOGGER = LoggerFactory.getLogger(SectionCtrl.class);

    private final SectionService sectionService;

    @Autowired
    public SectionCtrl(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @GetMapping("/names")
    @ResponseStatus(HttpStatus.OK)
    public List<SectionNameDTO> getAllSectionNames() {
        LOGGER.info("getAllSectionNames");
        return sectionService.getAllSectionNames();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SectionNameDTO findById(@PathVariable Long id) {
        LOGGER.info("findById");
        return sectionService.findById(id);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<SectionAllDTO> getAllSections() {
        LOGGER.info("getAllSections");
        return sectionService.getAllSections();
    }
}
