package com.math.example.demo.service;

import org.springframework.stereotype.Service;

import com.math.example.demo.model.Task;
import com.math.example.demo.repository.TaskRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
	
	private final NoteService noteService;
	private final TaskService taskService;
	private final TaskRepository repository;

	@Override
	public Mono<Task> findByID(String id) {
		return repository.findById(id);
	}

	@Override
	public Mono<Task> saveTask(String noteId, Task task) {
		return repository.save(task)
			.zipWith(noteService.findByID(noteId), 
				(task1, note) -> {
					note.getTasks().add(task1);
					noteService.saveNote(note).subscribe();
					return task1;
				});
	}
	
	@Override
	public Mono<Task> updateTask(String noteId, String taskId, Task task) {
		// TODO Auto-generated method stub
		return repository.save(task)
				.zipWith(noteService.findByID(noteId), 
					(task1, note) -> {
						noteService.saveNote(note).subscribe();
						return task1;
					});
	}

	@Override
	public void deleteTaskByID(String id) {
		repository.deleteById(id);
	}

	@Override
	public Flux<Task> findAllTask() {
		return repository.findAll();
	}

}
