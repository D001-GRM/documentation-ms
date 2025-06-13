package com.grm.documentation.services.interfaces;

import com.grm.documentation.models.dto.BlockContentDTO;
import com.grm.documentation.models.dto.BlockTitleDTO;
import com.grm.documentation.models.entities.Block;

import java.util.List;

public interface IBlockService {

    List<Block> findAll();
    Block findById(Long id);
    Block save(Block block);
    void deleteById(Long id);

    List<BlockTitleDTO> getBlockTitles(Long topicId);
    List<BlockContentDTO> findBlockByTopicIdOrderByPositionAsc(Long topicId);
    Object resolveContent(String type, Long referenceId);
}
