package com.grm.documentation.repositories;

import com.grm.documentation.models.entities.TableEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableEntityRepository extends JpaRepository<TableEntity,Long> {
}
