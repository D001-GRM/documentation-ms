package com.grm.documentation.models.dto;

public class BlockBasicDTO {

    private Long id;
    private String title;
    private String style;

    public BlockBasicDTO(Long id, String title, String style) {
        this.id = id;
        this.title = title;
        this.style = style;
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

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
