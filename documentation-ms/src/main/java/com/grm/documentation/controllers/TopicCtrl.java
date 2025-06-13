package com.grm.documentation.controllers;

import com.grm.documentation.models.dto.BlockContentDTO;
import com.grm.documentation.models.dto.TopicBasicIconDTO;
import com.grm.documentation.models.dto.TopicDTO;
import com.grm.documentation.models.dto.BlockTitleDTO;
import com.grm.documentation.services.BlockService;
import com.grm.documentation.services.TopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "https://grm.whocky.com")
@RestController
@RequestMapping("/documentation/topics")
public class TopicCtrl {
    private static final Logger LOGGER = LoggerFactory.getLogger(TopicCtrl.class);

    private final TopicService topicService;
    private final BlockService blockService;

    @Autowired
    public TopicCtrl(TopicService topicService, BlockService blockService) {
        this.topicService = topicService;
        this.blockService = blockService;
    }

    @GetMapping("/{topicId}/basic")
    @ResponseStatus(HttpStatus.OK)
    public TopicBasicIconDTO findTopicContentById(@PathVariable Long topicId) {
        LOGGER.info("findTopicContentById");
        return topicService.findTopicContentById(topicId);
    }

    @GetMapping("/{topicId}/titles")
    @ResponseStatus(HttpStatus.OK)
    public List<BlockTitleDTO> getBlockTitles(@PathVariable Long topicId) {
        LOGGER.info("getBlockTitles");
        return blockService.getBlockTitles(topicId);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<TopicDTO> getAllSections() {
        LOGGER.info("getAllTopics");
        return topicService.getAllTopics();
    }

    @GetMapping("{topicId}/content")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<BlockContentDTO>> findBlockByTopicIdOrderByPositionAsc(@PathVariable Long topicId) {
        List<BlockContentDTO> content = blockService.findBlockByTopicIdOrderByPositionAsc(topicId);
        LOGGER.info("findBlockByTopicIdOrderByPositionAsc");
        return ResponseEntity.ok(content);
    }


}
