package com.grm.documentation.services.interfaces;

import com.grm.documentation.models.dto.NoteDTO;
import com.grm.documentation.models.entities.Note;

import java.util.List;

public interface INoteService {

    List<Note> findAll();
    Note findById(Long id);
    Note save(Note note);
    void deleteById(Long id);

    List<NoteDTO> getAllNotes();
}
