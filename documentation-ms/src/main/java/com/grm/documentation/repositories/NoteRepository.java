package com.grm.documentation.repositories;

import com.grm.documentation.models.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
