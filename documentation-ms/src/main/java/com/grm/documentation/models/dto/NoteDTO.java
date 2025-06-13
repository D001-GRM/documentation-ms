package com.grm.documentation.models.dto;

import com.grm.documentation.models.entities.Note;

public class NoteDTO {

    private String title;
    private String content;

    public NoteDTO(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public static NoteDTO fromEntity(Note note) {
        return new NoteDTO(note.getTitle() ,note.getContent());
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
