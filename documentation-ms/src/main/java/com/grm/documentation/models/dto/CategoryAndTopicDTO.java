package com.grm.documentation.models.dto;

import com.grm.documentation.models.entities.Category;

import java.util.List;

public class CategoryAndTopicDTO {

    private Long id;
    private String name;
    private List<TopicBasicDTO> topics;
    private int position;

    public static CategoryAndTopicDTO fromEntity(Category category) {
        CategoryAndTopicDTO dto = new CategoryAndTopicDTO();
        dto.id = category.getId();
        dto.name = category.getName();
        dto.position = category.getPosition();
        dto.topics = category.getTopics().stream()
                .map(TopicBasicDTO::fromEntity)
                .toList();
        return dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public List<TopicBasicDTO> getTopics() {
        return topics;
    }

    public void setTopics(List<TopicBasicDTO> topics) {
        this.topics = topics;
    }
}
