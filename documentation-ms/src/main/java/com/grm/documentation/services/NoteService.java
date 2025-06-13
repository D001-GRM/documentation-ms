package com.grm.documentation.services;

import com.grm.documentation.models.dto.NoteDTO;
import com.grm.documentation.models.entities.Note;
import com.grm.documentation.repositories.NoteRepository;
import com.grm.documentation.services.interfaces.INoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class NoteService implements INoteService {

    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Note findById(Long id) {
        return noteRepository.findById(id).orElseThrow(() -> new RuntimeException("Note not found with id: " + id));
    }

    @Override
    @Transactional
    public Note save(Note note) {
        return noteRepository.save(note);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        noteRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<NoteDTO> getAllNotes() {
        return noteRepository.findAll().stream()
                .map(NoteDTO::fromEntity)
                .toList();
    }
}
