package com.math.example.demo;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.math.example.demo.controller.NoteController;
import com.math.example.demo.service.NoteService;


@ExtendWith(MockitoExtension.class)
public class NoteControllerTestClass {
	
	@Mock
	private NoteService noteService;
	
	@InjectMocks
	private NoteController noteController;

	

}
