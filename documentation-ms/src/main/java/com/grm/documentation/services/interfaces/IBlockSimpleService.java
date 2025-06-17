package com.grm.documentation.services.interfaces;

import com.grm.documentation.models.dto.BlockSimpleContentDTO;
import com.grm.documentation.models.dto.BlockTitleDTO;
import com.grm.documentation.models.entities.BlockSimple;

import java.util.List;

public interface IBlockSimpleService {

    List<BlockSimple> findAll();
    BlockSimple findById(Long id);
    BlockSimple save(BlockSimple blockSimple);
    void deleteById(Long id);

    List<BlockTitleDTO> getBlockTitles(Long topicId);
    List<BlockSimpleContentDTO> findBlockByBlockIdOrderByPositionAsc(Long topicId);
    Object resolveContent(String type, Long referenceId);
}
