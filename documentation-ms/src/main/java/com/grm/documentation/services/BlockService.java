package com.grm.documentation.services;

import com.grm.documentation.models.dto.BlockBasicDTO;
import com.grm.documentation.models.dto.BlockTitleDTO;
import com.grm.documentation.models.entities.Block;
import com.grm.documentation.repositories.BlockRepository;
import com.grm.documentation.services.interfaces.IBlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BlockService implements IBlockService {

    private final BlockRepository blockRepository;

    @Autowired
    public BlockService(BlockRepository blockRepository) {
        this.blockRepository = blockRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Block> findAll() {
        return blockRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Block findById(Long id) {
        return blockRepository.findById(id).orElseThrow(() -> new RuntimeException("Block not found with id: " + id));
    }

    @Override
    @Transactional
    public Block save(Block block) {
        return blockRepository.save(block);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        blockRepository.deleteById(id);
    }

    @Override
    public List<BlockTitleDTO> findTitlesSimpleByTopicIdOrderByPositionAsc(Long topicId) {
        return blockRepository.findTitlesSimpleByTopicIdOrderByPositionAsc(topicId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BlockBasicDTO> findByTopicIdOrderByPositionAsc(Long topicId) {
        return blockRepository.findByTopicIdOrderByPositionAsc(topicId);
    }
}
