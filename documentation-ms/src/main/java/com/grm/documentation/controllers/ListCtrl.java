package com.grm.documentation.controllers;

import com.grm.documentation.models.dto.ListBasicDTO;
import com.grm.documentation.services.ListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("https://grm.whocky.com")
@RestController
@RequestMapping("documentation/lists")
public class ListCtrl {
    private static final Logger LOGGER = LoggerFactory.getLogger(ListCtrl.class);
    private final ListService listService;

    @Autowired
    public ListCtrl(ListService listService) {
        this.listService = listService;
    }

    @GetMapping("/{listId}/basic")
    @ResponseStatus(HttpStatus.OK)
    public ListBasicDTO getListBasicDtoById(@PathVariable Long listId) {
        LOGGER.info("getListBasicDtoById");
        return listService.getListBasicDtoById(listId);
    }
}
