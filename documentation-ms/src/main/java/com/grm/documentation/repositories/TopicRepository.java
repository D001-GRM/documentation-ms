package com.grm.documentation.repositories;

import com.grm.documentation.models.entities.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {

    Topic findTopicById(Long id);
}