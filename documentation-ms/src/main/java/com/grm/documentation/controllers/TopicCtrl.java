package com.grm.documentation.controllers;

import com.grm.documentation.models.dto.TopicBasicIconDTO;
import com.grm.documentation.models.dto.TopicDTO;
import com.grm.documentation.services.TopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("https://grm.whocky.com")
@RestController
@RequestMapping("/documentation/topics")
public class TopicCtrl {
    private static final Logger LOGGER = LoggerFactory.getLogger(TopicCtrl.class);

    private final TopicService topicService;

    @Autowired
    public TopicCtrl(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping("/{topicId}/basic")
    @ResponseStatus(HttpStatus.OK)
    public TopicBasicIconDTO findTopicContentById(@PathVariable Long topicId) {
        LOGGER.info("findTopicContentById");
        return topicService.findTopicContentById(topicId);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<TopicDTO> getAllSections() {
        LOGGER.info("getAllTopics");
        return topicService.getAllTopics();
    }


}
