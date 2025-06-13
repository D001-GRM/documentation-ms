package com.grm.documentation.models.dto;

import com.grm.documentation.models.entities.TableCell;
import com.grm.documentation.models.entities.TableRow;

import java.util.Comparator;
import java.util.List;

public class TableRowBasicDTO {

    private Long id;
    private int position;
    private List<TableCellBasicDTO> cells;

    public static TableRowBasicDTO fromEntity(TableRow tableRow) {
        TableRowBasicDTO dto = new TableRowBasicDTO();
        dto.id = tableRow.getId();
        dto.position = tableRow.getPosition();
        dto.cells = tableRow.getCells().stream()
                .sorted(Comparator.comparingInt(TableCell::getPosition))
                .map(TableCellBasicDTO::fromEntity)
                .toList();
        return dto;
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

    public List<TableCellBasicDTO> getCells() {
        return cells;
    }

    public void setCells(List<TableCellBasicDTO> cells) {
        this.cells = cells;
    }
}
