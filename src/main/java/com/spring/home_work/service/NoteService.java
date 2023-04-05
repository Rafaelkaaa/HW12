package com.spring.home_work.service;

import com.spring.home_work.entity.Note;
import com.spring.home_work.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NoteService {
    @Autowired
    NoteRepository repository;

    public List<Note> listAll() {
        return repository.listAll();
    }

    public Note add(Note note) {
        repository.save(note);
        return note;
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }

    public void update(Note note) {
        repository.updateNoteById(note.getId(),
                note.getTitle(),
                note.getContent());
    }

    public Note getById(long id) {
        return repository.getNoteById(id);
    }
}