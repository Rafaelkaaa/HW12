package com.spring.home_work.service;

import com.spring.home_work.entity.Note;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteService {
    List<Note> notes;

    public List<Note> listAll() {
        return notes;
    }

    public Note add(Note note) {
        long id;
        if (notes != null) {
            id = notes.get(notes.size()-1).getId() + 1;
        } else {
            notes = new ArrayList<>();
            id = 1;
        }
        note.setId(id);
        notes.add(note);
        return note;
    }

    public void deleteById(long id) {
        notes.remove(getById(id));
    }

    public void update(Note note) {
        for (int i = 0; i < notes.size(); i++) {
            if (note.getId() == notes.get(i).getId()) {
                notes.set(i, note);
                return;
            }
        }
        throw new IllegalArgumentException("Note with ID " + note.getId() + " doesn't exist");
    }

    public Note getById(long id) {
        for (Note note : notes) {
            if (note.getId() == id) {
                return note;
            }
        }
        throw new IllegalArgumentException("Note with ID " + id + " doesn't exist");
    }
}
