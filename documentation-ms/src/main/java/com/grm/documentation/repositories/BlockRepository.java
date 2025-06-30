package com.grm.documentation.repositories;

import com.grm.documentation.models.dto.BlockBasicDTO;
import com.grm.documentation.models.dto.BlockTitleDTO;
import com.grm.documentation.models.entities.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BlockRepository extends JpaRepository<Block, Long> {

    List<BlockBasicDTO> findByTopicIdOrderByPositionAsc(Long topicId);

@Query(
    value = "SELECT " +
            "CASE bs.type " +
            "   WHEN 'paragraph' THEN (SELECT p.title FROM paragraph p WHERE p.id = bs.reference_id) " +
            "   WHEN 'note' THEN (SELECT n.title FROM note n WHERE n.id = bs.reference_id) " +
            "   WHEN 'list' THEN (SELECT l.title FROM list l WHERE l.id = bs.reference_id) " +
            "   WHEN 'code' THEN (SELECT c.title FROM code c WHERE c.id = bs.reference_id) " +
            "   WHEN 'table' THEN (SELECT t.title FROM table_entity t WHERE t.id = bs.reference_id) " +
            "END AS title, b.position " +
            "FROM block_simple bs " +
            "JOIN block b ON bs.block_id = b.id " +
            "WHERE b.topic_id = :topicId " +
            "UNION ALL " +
            "SELECT " +
            "CASE bf.type " +
            "   WHEN 'paragraph' THEN (SELECT p.title FROM paragraph p WHERE p.id = bf.reference_id) " +
            "   WHEN 'note' THEN (SELECT n.title FROM note n WHERE n.id = bf.reference_id) " +
            "   WHEN 'list' THEN (SELECT l.title FROM list l WHERE l.id = bf.reference_id) " +
            "   WHEN 'code' THEN (SELECT c.title FROM code c WHERE c.id = bf.reference_id) " +
            "   WHEN 'table' THEN (SELECT t.title FROM table_entity t WHERE t.id = bf.reference_id) " +
            "END AS title, b2.position " +
            "FROM block_fill bf " +
            "JOIN block b2 ON bf.block_id = b2.id " +
            "WHERE b2.topic_id = :topicId " +
            "ORDER BY 2 ASC",
    nativeQuery = true)
List<BlockTitleDTO> findTitlesSimpleByTopicIdOrderByPositionAsc(Long topicId);
}
