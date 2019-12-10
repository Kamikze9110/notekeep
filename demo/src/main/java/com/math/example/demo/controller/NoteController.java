package com.math.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.math.example.demo.model.Note;
import com.math.example.demo.model.Task;
import com.math.example.demo.service.NoteService;
import com.math.example.demo.service.TaskService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/note", produces = MediaType.APPLICATION_JSON_VALUE)
public class NoteController {
	
	private final NoteService noteService;
	private final TaskService taskService;
	
	
	@GetMapping
	public Flux<Note> getAllNote(){
		return noteService.findAllNote();
	}
	
	@GetMapping("/{id}")
	public Mono<Note> getNote(@PathVariable("id") String id){
		return noteService.findByID(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Note> createNote(@RequestBody Note note){
		return noteService.saveNote(note);
	}
	
	@PutMapping("/{id}")
	public Mono<Note> updateNote(@PathVariable("id") String id , @RequestBody Note note){
		return noteService.updateNote(note);
	}
	
	@DeleteMapping("/{id}")
	public Mono<Void> delete(@PathVariable("id") String id){
		return noteService.deleteNoteByID(id);
	}
	
	@PostMapping("/{noteId}/task")
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<Task> createTask(@RequestBody Task task, @PathVariable("noteId") String noteId) {
		return taskService.saveTask(noteId, task);
	}
	
	@PutMapping("/{noteId}/task/{taskId}")
	public Mono<Task> updateTask(@RequestBody Task task, 
			@PathVariable("noteId") String noteId, 
			@PathVariable("taskId") String taskId) {
		return taskService.updateTask(noteId , taskId , task);
	}
	
	@DeleteMapping("/task/{id}")
	public Mono<Void> deleteTask(@PathVariable("id") String id){
		return taskService.deleteTaskByID(id);
	}

}
