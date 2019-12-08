package com.math.example.demo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.math.example.demo.model.Task;

public interface TaskRepository extends ReactiveMongoRepository<Task, String>{

}
