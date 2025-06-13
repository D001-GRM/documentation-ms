package com.grm.documentation.models.dto;

import com.grm.documentation.models.entities.Category;

import java.util.List;

public class CategoryAllDTO {

    private String name;
    private List<TopicDTO> topics;

    public static CategoryAllDTO fromEntity(Category category) {
        CategoryAllDTO dto = new CategoryAllDTO();
        dto.name = category.getName();
        dto.topics = category.getTopics().stream()
                .map(TopicDTO::fromEntity)
                .toList();
        return dto;
    }

    public List<TopicDTO> getTopics() {
        return topics;
    }

    public void setTopics(List<TopicDTO> topics) {
        this.topics = topics;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
