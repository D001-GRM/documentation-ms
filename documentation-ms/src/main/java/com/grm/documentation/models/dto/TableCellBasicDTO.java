package com.grm.documentation.models.dto;

import com.grm.documentation.models.entities.TableCell;

public class TableCellBasicDTO {

    private Long id;
    private int position;
    private String value;

    public TableCellBasicDTO(Long id, int position, String value) {
        this.id = id;
        this.position = position;
        this.value = value;
    }

    public static TableCellBasicDTO fromEntity(TableCell tableCell) {
        return new TableCellBasicDTO(tableCell.getId(), tableCell.getPosition(), tableCell.getValue());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
