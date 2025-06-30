package com.grm.documentation.models.dto;

public class BlockTitleDTO {
    private String title;
    private int position;

    public BlockTitleDTO(String title, int position) {
        this.title = title;
        this.position = position;
    }

    public String getTitle() {
        return title;
    }

    public  void setTitle(String title) {
        this.title = title;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
