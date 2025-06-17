package com.grm.documentation.controllers;

import com.grm.documentation.models.dto.BlockBasicDTO;
import com.grm.documentation.models.dto.BlockSimpleContentDTO;
import com.grm.documentation.models.dto.BlockTitleDTO;
import com.grm.documentation.services.BlockFillService;
import com.grm.documentation.services.BlockService;
import com.grm.documentation.services.BlockSimpleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("https://grm.whocky.com")
@RestController
@RequestMapping("/documentation/blocks")
public class BlockCtrl {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlockCtrl.class);
    private final BlockSimpleService blockSimpleService;
    private final BlockFillService blockFillService;
    private final BlockService blockService;

    @Autowired
    public BlockCtrl(
            BlockSimpleService blockSimpleService,
            BlockFillService blockFillService,
            BlockService blockService
    ) {
        this.blockSimpleService = blockSimpleService;
        this.blockFillService = blockFillService;
        this.blockService = blockService;
    }

    @GetMapping("/{topicId}/titles")
    @ResponseStatus(HttpStatus.OK)
    public List<BlockTitleDTO> getBlockTitles(@PathVariable Long topicId) {
        LOGGER.info("getBlockTitles");
        return blockSimpleService.getBlockTitles(topicId);
    }

    @GetMapping("/{topicId}")
    @ResponseStatus(HttpStatus.OK)

    public List<BlockBasicDTO> findByTopicIdOrderByPositionAsc(@PathVariable Long topicId) {
        LOGGER.info("findByTopicIdOrderByPositionAsc");
        return blockService.findByTopicIdOrderByPositionAsc(topicId);
    }

    @GetMapping("{blockId}/content-simple")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<BlockSimpleContentDTO>> findBlockByBlockIdOrderByPositionAsc(@PathVariable Long blockId) {
        List<BlockSimpleContentDTO> content = blockSimpleService.findBlockByBlockIdOrderByPositionAsc(blockId);
        LOGGER.info("findBlockByBlockIdOrderByPositionAsc");
        return ResponseEntity.ok(content);
    }

    @GetMapping("{blockId}/content-fill")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<BlockSimpleContentDTO>> findBlockByBlockIdOrderByPositionAscFill(@PathVariable Long blockId) {
        List<BlockSimpleContentDTO> content = blockFillService.findBlockByBlockIdOrderByPositionAsc(blockId);
        LOGGER.info("findBlockByBlockIdOrderByPositionAscFill");
        return ResponseEntity.ok(content);
    }
}
