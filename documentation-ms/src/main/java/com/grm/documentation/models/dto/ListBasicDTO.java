package com.grm.documentation.models.dto;
import com.grm.documentation.models.entities.List;

public class ListBasicDTO {

    private Long id;
    private String title;
    private String description;
    private java.util.List<ListItemBasicDTO> listItems;

    public static ListBasicDTO fromEntity(List list) {
        ListBasicDTO dto = new ListBasicDTO();
        dto.id = list.getId();
        dto.title = list.getTitle();
        dto.description = list.getDescription();
        dto.listItems = list.getItems().stream().map(ListItemBasicDTO::fromEntity).toList();
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

    public java.util.List<ListItemBasicDTO> getListItems() {
        return listItems;
    }

    public void setListItems(java.util.List<ListItemBasicDTO> listItems) {
        this.listItems = listItems;
    }
}
