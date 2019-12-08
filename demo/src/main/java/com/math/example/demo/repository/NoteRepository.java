package com.math.example.demo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.math.example.demo.model.Note;

public interface NoteRepository extends ReactiveMongoRepository<Note, String>{

}
