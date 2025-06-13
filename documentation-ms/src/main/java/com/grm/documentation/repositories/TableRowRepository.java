package com.grm.documentation.repositories;

import com.grm.documentation.models.entities.TableRow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRowRepository extends JpaRepository<TableRow,Long> {
}
