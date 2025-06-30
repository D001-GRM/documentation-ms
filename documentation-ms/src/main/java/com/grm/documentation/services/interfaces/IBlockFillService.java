package com.grm.documentation.services.interfaces;

import com.grm.documentation.models.dto.BlockSimpleContentDTO;
import com.grm.documentation.models.entities.BlockFill;

import java.util.List;

public interface IBlockFillService {

    List<BlockFill> findAll();
    BlockFill findById(Long id);
    BlockFill save(BlockFill blockFill);
    void deleteById(Long id);

    List<BlockSimpleContentDTO> findBlockByBlockIdOrderByPositionAsc(Long topicId);
    Object resolveContent(String type, Long referenceId);
}
