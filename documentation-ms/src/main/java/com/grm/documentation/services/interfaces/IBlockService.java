package com.grm.documentation.services.interfaces;

import com.grm.documentation.models.dto.BlockBasicDTO;
import com.grm.documentation.models.dto.BlockTitleDTO;
import com.grm.documentation.models.entities.Block;

import java.util.List;

public interface IBlockService {

    List<Block> findAll();
    Block findById(Long id);
    Block save(Block block);
    void deleteById(Long id);

    List<BlockTitleDTO> findTitlesSimpleByTopicIdOrderByPositionAsc(Long topicId);
    List<BlockBasicDTO> findByTopicIdOrderByPositionAsc(Long topicId);
}
