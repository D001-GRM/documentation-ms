package com.grm.documentation.models.dto;

import com.grm.documentation.models.entities.Section;

public class SectionNameDTO {
    private Long id;
    private String name;
    private String icon;
    private int position;

    public SectionNameDTO(Long id, String name, String icon, int position) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.position = position;
    }

    public static SectionNameDTO fromEntity(Section section) {
        return new SectionNameDTO(section.getId(), section.getName(), section.getIcon(), section.getPosition());
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}