package com.math.example.demo.mapper;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.math.example.demo.model.Note;



public class NoteMapperTest {

	@Test
	public void convertToDto_whenEntityIsNull_returnNull() {
		Note note = null;
		assertNull(note);
	}
	
	@Test
	public void convertToDto_whenEntity_returnDTO() {
		Note note = new Note();
		note.setDescription("Clean dishes");
		assertEquals(note.getDescription(), "Clean dishes");

	}
	
	@Test
	public void convertToEntity_whenDTOIsNull_returnNull() {
		Note note = null;
		assertNull(note);
	}

	@Test
	public void convertAllToDtos_whenListIsEmpty_returnEmpty() {
		List<Note> entitiesList = new ArrayList<>();
		
		assertTrue(entitiesList.isEmpty());
	}
	
	@Test
	public void convertAllToDtos_whenListHasEntities_returnListDtos() {
		List<Note> entitiesList = new ArrayList<>();
		
		Note note1 = new Note();
		Note note2 = new Note();
		
		note1.setDescription("Note 1");
		note2.setDescription("Note 2");
		entitiesList.add(note1);
		entitiesList.add(note2);
		
		assertFalse(entitiesList.isEmpty());
	}
	
	@Test
	public void convertAllToEntities_whenListIsEmpty_returnEmpty() {
		List<Note> dtosList = new ArrayList<>();
		assertTrue(dtosList.isEmpty());
	}

	
	
	
}
