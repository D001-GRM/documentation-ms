package com.grm.documentation.controllers;

import com.grm.documentation.models.dto.ListItemBasicDTO;
import com.grm.documentation.services.ListItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("https://grm.whocky.com")
@RestController
@RequestMapping("documentation/list-items")
public class ListItemCtrl {
    private static final Logger LOGGER = LoggerFactory.getLogger(ListItemCtrl.class);
    private final ListItemService listItemService;

    @Autowired
    public ListItemCtrl(ListItemService listItemService) {
        this.listItemService = listItemService;
    }

    @GetMapping("/list/{listId}")
    @ResponseStatus(HttpStatus.OK)
    public List<ListItemBasicDTO> getListItemsByListIdOrderByPositionAsc(@PathVariable Long listId) {
        LOGGER.info("getListItemsByListId");
        return listItemService.getListItemsByListIdOrderByPositionAsc(listId);
    }
}
