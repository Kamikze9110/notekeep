package com.math.example.demo.service;

import com.math.example.demo.model.Note;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface NoteService {
	
    Mono<Note> findByID(String id);
	
    Mono<Note> saveNote(Note note);
	
    Mono<Note> updateNote(Note note);
	
    Mono<Void> deleteNoteByID(String id);
	
	Flux<Note> findAllNote();
	
}
