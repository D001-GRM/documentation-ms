package com.grm.documentation.repositories;

import com.grm.documentation.models.entities.BlockSimple;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlockSimpleRepository extends JpaRepository<BlockSimple, Long> {

    List<BlockSimple> findBlockByBlockIdOrderByPositionAsc(Long topicId);
}
