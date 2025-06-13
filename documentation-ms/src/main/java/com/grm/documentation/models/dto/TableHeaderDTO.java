package com.grm.documentation.models.dto;

import com.grm.documentation.models.entities.TableHeader;

public class TableHeaderDTO {

    private Long id;
    private String name;
    private int position;

    public TableHeaderDTO (Long id, String name, int position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    public static TableHeaderDTO fromEntity(TableHeader tableHeader) {
        return new TableHeaderDTO(tableHeader.getId(), tableHeader.getName(), tableHeader.getPosition());
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
