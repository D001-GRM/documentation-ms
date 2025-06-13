package com.grm.documentation.models.dto;

import com.grm.documentation.models.entities.TableEntity;
import com.grm.documentation.models.entities.TableHeader;
import com.grm.documentation.models.entities.TableRow;

import java.util.Comparator;
import java.util.List;

public class TableBasicDTO {

    private Long id;
    private String title;
    private String description;
    private List<TableRowBasicDTO> rows;
    private List<TableHeaderDTO> headers;

    public static TableBasicDTO fromEntity(TableEntity tableEntity) {
        TableBasicDTO dto = new TableBasicDTO();
        dto.id = tableEntity.getId();
        dto.title = tableEntity.getTitle();
        dto.description = tableEntity.getDescription();
        dto.rows = tableEntity.getRows().stream()
                .sorted(Comparator.comparingInt(TableRow::getPosition))
                .map(TableRowBasicDTO::fromEntity)
                .toList();
        dto.headers = tableEntity.getHeaders().stream()
                .sorted(Comparator.comparingInt(TableHeader::getPosition))
                .map(TableHeaderDTO::fromEntity)
                .toList();
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

    public List<TableRowBasicDTO> getRows() {
        return rows;
    }

    public void setRows(List<TableRowBasicDTO> rows) {
        this.rows = rows;
    }

    public List<TableHeaderDTO> getHeaders() {
        return headers;
    }

    public void setHeaders(List<TableHeaderDTO> headers) {
        this.headers = headers;
    }
}
