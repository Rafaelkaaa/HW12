package com.spring.home_work.repository;

import com.spring.home_work.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public interface NoteRepository extends JpaRepository<Note, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM NOTE")
    List<Note> listAll();

    @Modifying
    @Query(nativeQuery = true, value = "UPDATE Note " +
            "SET title = :title, content = :content " +
            "WHERE id = :id")
    void updateNoteById(long id, String title, String content);

    Note getNoteById(long id);

}
