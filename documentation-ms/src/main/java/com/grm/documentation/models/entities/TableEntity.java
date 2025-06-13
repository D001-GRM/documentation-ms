package com.grm.documentation.models.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Crear tablas mas interactivas con headers o rows de diferentes tiposd (icons, checkboxes, etc.)
 * Agregar tabla de version
 */
@Entity
public class TableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "table", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TableHeader> headers = new ArrayList<>();

    @OneToMany(mappedBy = "table", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TableRow> rows = new ArrayList<>();

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

    public List<TableHeader> getHeaders() {
        return headers;
    }

    public void setHeaders(List<TableHeader> headers) {
        this.headers = headers;
    }

    public List<TableRow> getRows() {
        return rows;
    }

    public void setRows(List<TableRow> rows) {
        this.rows = rows;
    }
}
