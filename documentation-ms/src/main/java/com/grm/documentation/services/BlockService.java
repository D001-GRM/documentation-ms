package com.grm.documentation.services;

import com.grm.documentation.models.dto.BlockContentDTO;
import com.grm.documentation.models.dto.BlockTitleDTO;
import com.grm.documentation.models.dto.ListBasicDTO;
import com.grm.documentation.models.dto.TableBasicDTO;
import com.grm.documentation.models.entities.Block;
import com.grm.documentation.models.entities.Note;
import com.grm.documentation.models.entities.Paragraph;
import com.grm.documentation.models.entities.TableEntity;
import com.grm.documentation.repositories.*;
import com.grm.documentation.services.interfaces.IBlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class BlockService implements IBlockService {

    private final BlockRepository blockRepository;
    private final ParagraphRepository paragraphRepository;
    private final NoteRepository noteRepository;
    private final ListRepository listRepository;
    private final TableEntityRepository tableEntityRepository;

    @Autowired
    public BlockService(
            BlockRepository blockRepository,
            ParagraphRepository paragraphRepository,
            NoteRepository noteRepository,
            ListRepository listRepository,
            TableEntityRepository tableEntityRepository
    ) {
        this.blockRepository = blockRepository;
        this.paragraphRepository = paragraphRepository;
        this.noteRepository = noteRepository;
        this.listRepository = listRepository;
        this.tableEntityRepository = tableEntityRepository;
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
    public Block save(Block block) {
        return blockRepository.save(block);
    }

    @Override
    public void deleteById(Long id) {
        blockRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BlockTitleDTO> getBlockTitles(Long topicId) {
        List<Block> blocks = blockRepository.findBlockByTopicIdOrderByPositionAsc(topicId);
        List<BlockTitleDTO> titles = new ArrayList<>();

        for (Block block : blocks) {
            String type = block.getType();
            Long refId = block.getReferenceId();

            String title = switch (type) {
                case "paragraph" -> paragraphRepository.findById(refId)
                        .map(Paragraph::getTitle).orElse(null);
                case "note" -> noteRepository.findById(refId)
                        .map(Note::getTitle).orElse(null);
                case "list" -> listRepository.findById(refId)
                        .map(com.grm.documentation.models.entities.List::getTitle).orElse(null);
                case "table" -> tableEntityRepository.findById(refId)
                        .map(TableEntity::getTitle).orElse(null);
                default -> null;
            };

            if (title != null && !title.isBlank()) {
                titles.add(new BlockTitleDTO(refId, type, title));
            }
        }

        return titles;
    }

    @Override
    @Transactional(readOnly = true)
    public List<BlockContentDTO> findBlockByTopicIdOrderByPositionAsc(Long topicId) {
        List<Block> blocks = blockRepository.findBlockByTopicIdOrderByPositionAsc(topicId);
        List<BlockContentDTO> result = new ArrayList<>();
        for (Block block : blocks) {
            Object content = resolveContent(block.getType(), block.getReferenceId());
            if (content != null) {
                result.add(new BlockContentDTO(block.getId(), block.getType(), content));
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
            // Add more types
            default -> null;
        };
    }
}
