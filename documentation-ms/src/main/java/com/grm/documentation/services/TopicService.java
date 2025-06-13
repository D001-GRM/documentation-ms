package com.grm.documentation.services;

import com.grm.documentation.models.dto.TopicBasicIconDTO;
import com.grm.documentation.models.dto.TopicDTO;
import com.grm.documentation.models.dto.BlockTitleDTO;
import com.grm.documentation.models.entities.Topic;
import com.grm.documentation.repositories.TopicRepository;
import com.grm.documentation.services.interfaces.ITopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class TopicService implements ITopicService {

    private final TopicRepository topicRepository;

    @Autowired
    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Topic> findAll() {
        return topicRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Topic findById(Long id) {
        return topicRepository.findById(id).orElseThrow(() -> new RuntimeException("Topic not found with id: " + id));
    }

    @Override
    @Transactional
    public Topic save(Topic topic) {
        return topicRepository.save(topic);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        topicRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public TopicBasicIconDTO findTopicContentById(Long topicId) {
        Topic topic = topicRepository.findTopicById(topicId);
        return TopicBasicIconDTO.fromEntity(topic);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TopicDTO> getAllTopics() {
        return topicRepository.findAll().stream()
                .map(TopicDTO::fromEntity)
                .toList();
    }
}
