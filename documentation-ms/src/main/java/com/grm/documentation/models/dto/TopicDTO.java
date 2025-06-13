package com.grm.documentation.models.dto;

import com.grm.documentation.models.entities.Topic;

public class TopicDTO {
    private Long id;
    private String title;
    private String description;

    public static TopicDTO fromEntity(Topic topic) {
        TopicDTO dto = new TopicDTO();
        dto.id = topic.getId();
        dto.title = topic.getTitle();
        dto.description = topic.getDescription();
        return dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}