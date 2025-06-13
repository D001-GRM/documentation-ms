package com.grm.documentation.models.dto;

import com.grm.documentation.models.entities.ListItem;

public class ListItemBasicDTO {

    private Long id;
    private String label;
    private String description;
    private int position;

    public ListItemBasicDTO(Long id, String label, String description, int position) {
        this.id = id;
        this.label = label;
        this.description = description;
        this.position = position;
    }

    public static ListItemBasicDTO fromEntity(ListItem entity) {
        return new ListItemBasicDTO(entity.getId(), entity.getLabel(), entity.getDescription(), entity.getPosition());
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
