package com.grm.documentation.models.entities;

import jakarta.persistence.*;

@Entity
public class TableCell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int position;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String value;

    @ManyToOne
    @JoinColumn(name = "table_row_id", nullable = false)
    private TableRow tableRow;

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

    public TableRow getTableRow() {
        return tableRow;
    }

    public void setTableRow(TableRow tableRow) {
        this.tableRow = tableRow;
    }
}
