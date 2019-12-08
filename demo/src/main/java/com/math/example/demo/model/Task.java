package com.math.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Document(collection = "task")
public class Task {
	
	@Id
	private String id; 
	
	private String description;

}
