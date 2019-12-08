package com.math.example.demo.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Document(collection = "note")
public class Note implements Serializable{

	private static final long serialVersionUID = 211757628984808759L;

	@Id
	private String id; 
	
	private String description;
	
	@DBRef
	private Set<Task> tasks = new HashSet<>();

}
