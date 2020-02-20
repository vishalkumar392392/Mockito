package com.mockito.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mockito.model.Student;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@GetMapping("/students")
	public Student getStudentName() {
		return new Student("vishal","vishal@gmail.com","8143486643");
	}
	@PostMapping("/addStudent")
	public Student createStudent(@RequestBody Student student) {
		
		return student;
	}

}
