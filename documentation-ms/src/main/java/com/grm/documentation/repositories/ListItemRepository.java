package com.grm.documentation.repositories;

import com.grm.documentation.models.dto.ListItemBasicDTO;
import com.grm.documentation.models.entities.ListItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ListItemRepository extends JpaRepository<ListItem, Long> {

    List<ListItemBasicDTO> getListItemsByListIdOrderByPositionAsc(Long listId);

}
