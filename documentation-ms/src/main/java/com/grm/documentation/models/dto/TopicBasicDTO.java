package com.grm.documentation.models.dto;

import com.grm.documentation.models.entities.Topic;

public class TopicBasicDTO {

    private Long id;
    private  String title;

    public TopicBasicDTO(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public static TopicBasicDTO fromEntity(Topic topic) {
        return new TopicBasicDTO(topic.getId(), topic.getTitle());
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
}
