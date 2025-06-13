package com.grm.documentation.models.dto;

import com.grm.documentation.models.entities.Section;
import java.util.List;

public class SectionAllDTO {

    private String name;
    private List<CategoryAllDTO> category;

    public static SectionAllDTO fromEntity(Section section) {
        SectionAllDTO dto = new SectionAllDTO();
        dto.name = section.getName();
        dto.category = section.getCategories().stream()
                .map(CategoryAllDTO::fromEntity)
                .toList();
        return dto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CategoryAllDTO> getTopics() {
        return category;
    }

    public void setTopics(List<CategoryAllDTO> topics) {
        this.category = topics;
    }
}
