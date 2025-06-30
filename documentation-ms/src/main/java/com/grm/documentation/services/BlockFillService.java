package com.grm.documentation.services;

import com.grm.documentation.models.dto.BlockSimpleContentDTO;
import com.grm.documentation.models.dto.ListBasicDTO;
import com.grm.documentation.models.dto.TableBasicDTO;
import com.grm.documentation.models.entities.*;
import com.grm.documentation.repositories.*;
import com.grm.documentation.services.interfaces.IBlockFillService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlockFillService implements IBlockFillService {

    private final BlockFillRepository blockFillRepository;
    private final ParagraphRepository paragraphRepository;
    private final NoteRepository noteRepository;
    private final ListRepository listRepository;
    private final TableEntityRepository tableEntityRepository;
    private final CodeRepository codeRepository;

    public BlockFillService(
            BlockFillRepository blockFillRepository,
            ParagraphRepository paragraphRepository,
            NoteRepository noteRepository,
            ListRepository listRepository,
            TableEntityRepository tableEntityRepository,
            CodeRepository codeRepository
    ) {
        this.blockFillRepository = blockFillRepository;
        this.paragraphRepository = paragraphRepository;
        this.noteRepository = noteRepository;
        this.listRepository = listRepository;
        this.tableEntityRepository = tableEntityRepository;
        this.codeRepository = codeRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<BlockFill> findAll() {
        return blockFillRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public BlockFill findById(Long id) {
        return blockFillRepository.findById(id).orElseThrow(() -> new RuntimeException("BlockFill not found with id: " + id));
    }

    @Override
    @Transactional
    public BlockFill save(BlockFill blockFill) {
        return blockFillRepository.save(blockFill);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        blockFillRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BlockSimpleContentDTO> findBlockByBlockIdOrderByPositionAsc(Long topicId) {
        List<BlockFill> blockFills = blockFillRepository.findBlockByBlockIdOrderByPositionAsc(topicId);
        List<BlockSimpleContentDTO> result = new ArrayList<>();
        for (BlockFill blockFill : blockFills) {
            Object content = resolveContent(blockFill.getType(), blockFill.getReferenceId());
            if (content != null) {
                result.add(new BlockSimpleContentDTO(blockFill.getId(), blockFill.getType(), content));
            }
        }

        return result;
    }

    @Override
    public Object resolveContent(String type, Long referenceId) {
        return switch (type) {
            case "paragraph" -> paragraphRepository.findById(referenceId).orElseThrow(() -> new RuntimeException("Paragraph not found with id: " + referenceId));
            case "note" -> noteRepository.findById(referenceId).orElseThrow(() -> new RuntimeException("Note not found with id: " + referenceId));
            case "list" -> listRepository.findById(referenceId).map(ListBasicDTO::fromEntity).orElseThrow(() -> new RuntimeException("List not found with id: " + referenceId));
            case "table" -> tableEntityRepository.findById(referenceId).map(TableBasicDTO::fromEntity).orElseThrow(() -> new RuntimeException("Table not found with id: " + referenceId));
            case "code" -> codeRepository.findById(referenceId).orElseThrow(() -> new RuntimeException("Code not found with id: " + referenceId));
            // Add more types
            default -> null;
        };
    }

}
