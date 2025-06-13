package com.grm.documentation.services.interfaces;

import com.grm.documentation.models.dto.TopicBasicIconDTO;
import com.grm.documentation.models.dto.TopicDTO;
import com.grm.documentation.models.dto.BlockTitleDTO;
import com.grm.documentation.models.entities.Topic;

import java.util.List;

public interface ITopicService {

    List<Topic> findAll();
    Topic findById(Long id);
    Topic save(Topic topic);
    void deleteById(Long id);

    TopicBasicIconDTO findTopicContentById(Long topicId);
    List<TopicDTO> getAllTopics();
}
