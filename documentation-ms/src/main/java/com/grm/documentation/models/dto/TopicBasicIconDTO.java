package com.grm.documentation.models.dto;

import com.grm.documentation.models.entities.Topic;

public class TopicBasicIconDTO {

    private Long id;
    private String title;
    private String description;
    private String icon;

    public TopicBasicIconDTO(Long id, String title, String description, String icon) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.icon = icon;
    }

    public static TopicBasicIconDTO fromEntity(Topic topic) {
        return new TopicBasicIconDTO(
            topic.getId(),
            topic.getTitle(),
            topic.getDescription(),
            topic.getIcon()
        );
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
