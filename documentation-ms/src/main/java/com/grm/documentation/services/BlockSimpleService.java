package com.grm.documentation.services;

import com.grm.documentation.models.dto.BlockSimpleContentDTO;
import com.grm.documentation.models.dto.BlockTitleDTO;
import com.grm.documentation.models.dto.ListBasicDTO;
import com.grm.documentation.models.dto.TableBasicDTO;
import com.grm.documentation.models.entities.*;
import com.grm.documentation.repositories.*;
import com.grm.documentation.services.interfaces.IBlockSimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class BlockSimpleService implements IBlockSimpleService {

    private final BlockSimpleRepository blockSimpleRepository;
    private final ParagraphRepository paragraphRepository;
    private final NoteRepository noteRepository;
    private final ListRepository listRepository;
    private final TableEntityRepository tableEntityRepository;
    private final CodeRepository codeRepository;

    @Autowired
    public BlockSimpleService(
            BlockSimpleRepository blockSimpleRepository,
            ParagraphRepository paragraphRepository,
            NoteRepository noteRepository,
            ListRepository listRepository,
            TableEntityRepository tableEntityRepository,
            CodeRepository codeRepository

    ) {
        this.blockSimpleRepository = blockSimpleRepository;
        this.paragraphRepository = paragraphRepository;
        this.noteRepository = noteRepository;
        this.listRepository = listRepository;
        this.tableEntityRepository = tableEntityRepository;
        this.codeRepository = codeRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<BlockSimple> findAll() {
        return blockSimpleRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public BlockSimple findById(Long id) {
        return blockSimpleRepository.findById(id).orElseThrow(() -> new RuntimeException("Block not found with id: " + id));
    }

    @Override
    public BlockSimple save(BlockSimple blockSimple) {
        return blockSimpleRepository.save(blockSimple);
    }

    @Override
    public void deleteById(Long id) {
        blockSimpleRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BlockSimpleContentDTO> findBlockByBlockIdOrderByPositionAsc(Long topicId) {
        List<BlockSimple> blockSimples = blockSimpleRepository.findBlockByBlockIdOrderByPositionAsc(topicId);
        List<BlockSimpleContentDTO> result = new ArrayList<>();
        for (BlockSimple blockSimple : blockSimples) {
            Object content = resolveContent(blockSimple.getType(), blockSimple.getReferenceId());
            if (content != null) {
                result.add(new BlockSimpleContentDTO(blockSimple.getId(), blockSimple.getType(), content));
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
