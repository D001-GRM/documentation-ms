package com.grm.documentation.repositories;

import com.grm.documentation.models.dto.BlockBasicDTO;
import com.grm.documentation.models.entities.Block;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlockRepository extends JpaRepository<Block, Long> {

    List<BlockBasicDTO> findByTopicIdOrderByPositionAsc(Long topicId);
}
