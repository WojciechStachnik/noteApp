package com.stachnik.wojciech.noteApp.repository;

import com.stachnik.wojciech.noteApp.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}
