package com.math.example.demo.service;

import org.springframework.stereotype.Service;

import com.math.example.demo.model.Note;
import com.math.example.demo.repository.NoteRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {
	
	private final NoteRepository repository;

	@Override
	public Mono<Note> findByID(String id) {
		return repository.findById(id);
	}

	@Override
	public Mono<Note> saveNote(Note note) {
		return repository.save(note);
	}

	@Override
	public Mono<Note> updateNote(Note note) {
		return repository.save(note);
	}

	@Override
	public Mono<Void> deleteNoteByID(String id) {
		return repository.deleteById(id);
	}

	@Override
	public Flux<Note> findAllNote() {
		return repository.findAll();
	}

}
