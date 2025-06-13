package com.grm.documentation.repositories;

import com.grm.documentation.models.entities.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListRepository extends JpaRepository<List,Long> {


}
