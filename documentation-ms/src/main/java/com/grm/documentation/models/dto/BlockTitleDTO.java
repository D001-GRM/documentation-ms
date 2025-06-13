package com.grm.documentation.models.dto;

public class BlockTitleDTO {
    private Long id;
    private String type;
    private String title;

    public BlockTitleDTO(Long id, String type, String title) {
        this.id = id;
        this.type = type;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public  void setTitle(String title) {
        this.title = title;
    }
}
