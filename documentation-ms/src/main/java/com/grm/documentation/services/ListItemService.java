package com.grm.documentation.services;

import com.grm.documentation.models.dto.ListItemBasicDTO;
import com.grm.documentation.models.entities.ListItem;
import com.grm.documentation.repositories.ListItemRepository;
import com.grm.documentation.services.interfaces.IListItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ListItemService implements IListItemService {

    private final ListItemRepository listItemRepository;

    @Autowired
    public ListItemService(ListItemRepository listItemRepository) {
        this.listItemRepository = listItemRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ListItem> getListItems() {
        return listItemRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public ListItem getListItemById(Long id) {
        return listItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ListItem not found with id: " + id));
    }

    @Override
    @Transactional
    public ListItem saveListItem(ListItem listItem) {
        return listItemRepository.save(listItem);
    }

    @Override
    @Transactional
    public void deleteListItemById(Long id) {
        listItemRepository.deleteById(id);
    }

    @Override
    public java.util.List<ListItemBasicDTO> getListItemsByListIdOrderByPositionAsc(Long listId) {
        return listItemRepository.getListItemsByListIdOrderByPositionAsc(listId);
    }
}
