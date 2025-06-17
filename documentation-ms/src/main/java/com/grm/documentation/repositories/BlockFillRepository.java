package com.grm.documentation.repositories;

import com.grm.documentation.models.entities.BlockFill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlockFillRepository extends JpaRepository<BlockFill, Long> {

    List<BlockFill> findBlockByBlockIdOrderByPositionAsc(Long topicId);
}
