package com.stachnik.wojciech.noteApp.controller;

import com.stachnik.wojciech.noteApp.exception.ResourceNotFoundException;
import com.stachnik.wojciech.noteApp.model.Note;
import com.stachnik.wojciech.noteApp.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class NoteController {
    @Autowired
    private NoteRepository noteRepository;

    //get notes
    @GetMapping("/notes")
    public List<Note> getAllNotes(){
        return  noteRepository.findAll();
    }

    //add notes
    @PostMapping("/notes")
    public Note createNote(@Valid @RequestBody Note note){
        return noteRepository.save(note);
    }

    //read one note
    @GetMapping("/notes/{id}")
    public Note getOneNote(@PathVariable(value = "id")Long noteId){
        return noteRepository.findById(noteId).orElseThrow(()-> new ResourceNotFoundException("Note", "id", noteId));
    }

    //update note by id
    @PutMapping("/notes/{id}")
    public Note updateOneNote(@PathVariable(value = "id")Long noteId,@Valid @RequestBody Note noteDetails){

        Note note = noteRepository.findById(noteId).orElseThrow(()-> new ResourceNotFoundException("Note", "id", noteId));

        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());
        return noteRepository.save(note);
    }

    //delete note by id
    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
        Note note = noteRepository.findById(noteId).orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
        noteRepository.delete(note);
        return ResponseEntity.ok().build();
    }
}

