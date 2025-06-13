package com.grm.documentation.repositories;

import com.grm.documentation.models.entities.Block;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlockRepository extends JpaRepository<Block, Long> {

    List<Block> findBlockByTopicIdOrderByPositionAsc(Long topicId);
}
