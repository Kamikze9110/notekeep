package com.math.example.demo.service;

import com.math.example.demo.model.Task;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TaskService {
	
    Mono<Task> findByID(String id);
	
    Mono<Task> saveTask(String noteId, Task task);
	
    Mono<Task> updateTask(String noteId, String taskId, Task task);
	
    Mono<Void> deleteTaskByID(String id);
	
	Flux<Task> findAllTask();

}
