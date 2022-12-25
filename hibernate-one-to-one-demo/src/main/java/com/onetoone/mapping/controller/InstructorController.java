package com.onetoone.mapping.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onetoone.mapping.entity.Instructor;
import com.onetoone.mapping.repository.InstructorRepositosity;


@RestController
@RequestMapping("/instructor")
public class InstructorController {
	
	@Autowired
	private InstructorRepositosity instructorRepositosity;
	
	@GetMapping()
	public List<Instructor> getAllInstructors(){
		return instructorRepositosity.findAll();
	}
	
	@GetMapping("/{theId}")
	public Instructor getById(@PathVariable int theId) {
		Optional<Instructor> findById = instructorRepositosity.findById(theId);
		if(findById.isPresent())
			return findById.get();
		return null;
	}
	
	@DeleteMapping("/{theId}")
	public void deleteById(@PathVariable int theId) {
		instructorRepositosity.deleteById(theId);
	}
	
	@PostMapping()
	public void addInstructor(@RequestBody Instructor theInstructor) {
		instructorRepositosity.save(theInstructor);
	}
	

}








