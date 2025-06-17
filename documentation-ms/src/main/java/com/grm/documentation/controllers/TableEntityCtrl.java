package com.grm.documentation.controllers;

import com.grm.documentation.models.dto.TableBasicDTO;
import com.grm.documentation.models.entities.TableEntity;
import com.grm.documentation.services.TableEntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("https://grm.whocky.com")
@RestController
@RequestMapping("documentation/tables")
public class TableEntityCtrl {
    private static final Logger LOGGER = LoggerFactory.getLogger(TableEntityCtrl.class);
    private final TableEntityService tableEntityService;

    public TableEntityCtrl(TableEntityService tableEntityService) {
        this.tableEntityService = tableEntityService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<TableEntity> getAllTables() {
        LOGGER.info("getAllTables");
        return tableEntityService.getAll();
    }

    @GetMapping("/{tableId}/basic")
    @ResponseStatus(HttpStatus.OK)
    public TableBasicDTO getTableBasicDtoById(@PathVariable Long tableId) {
        LOGGER.info("getTableBasicDtoById");
        return tableEntityService.getTableBasicDtoById(tableId);
    }
}
