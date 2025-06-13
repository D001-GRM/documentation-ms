package com.grm.documentation.models.dto;

import com.grm.documentation.models.entities.Paragraph;

public class ParagraphDTO {

    private String title;
    private String content;

    public ParagraphDTO(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public static ParagraphDTO fromEntity(Paragraph paragraph) {
        return new ParagraphDTO(paragraph.getTitle(), paragraph.getContent());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}