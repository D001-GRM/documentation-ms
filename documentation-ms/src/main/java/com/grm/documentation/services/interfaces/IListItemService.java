package com.grm.documentation.services.interfaces;

import com.grm.documentation.models.dto.ListItemBasicDTO;
import com.grm.documentation.models.entities.ListItem;

import java.util.List;

public interface IListItemService {

    List<ListItem> getListItems();
    ListItem getListItemById(Long id);
    ListItem saveListItem(ListItem listItem);
    void deleteListItemById(Long id);
    List<ListItemBasicDTO> getListItemsByListIdOrderByPositionAsc(Long listId);
}
