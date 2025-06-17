package com.grm.documentation.models.dto;

public class BlockSimpleContentDTO {

    private Long id;
    private String type;
    private Object content;

    public BlockSimpleContentDTO(Long id, String type, Object content) {
        this.id = id;
        this.type = type;
        this.content = content;
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

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
