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
import com.onetoone.mapping.entity.InstructorDetail;
import com.onetoone.mapping.repository.InstructorDetailRepository;

@RestController
@RequestMapping("/instructorDetail")
public class InstructorDetailController {
	
	@Autowired
	private InstructorDetailRepository instructorDetailRepository;
	
	@GetMapping()
	public List<InstructorDetail> getAllInstructorDetails(){
		return instructorDetailRepository.findAll();
	}
	
	@GetMapping("/{theId}")
	public InstructorDetail getById(@PathVariable int theId) {
		Optional<InstructorDetail> findById = instructorDetailRepository.findById(theId);
		if(findById.isPresent())
			return findById.get();
		return null;
	}
	
	@PostMapping()
	public void saveInstructorDetail(@RequestBody InstructorDetail theInstructorDetail) {
		instructorDetailRepository.save(theInstructorDetail);
	}
	
	@DeleteMapping("/{theId}")
	public void deleteById(@PathVariable int theId) {
//		As we've onetoone mapping from both the sides and we don't want to delete isntructor table
//		when deleting instructorDetial row we've to first detach the instructor detail from that particular 
//		instructor row, which will allow us to then delete the instructor detail row.
//		If not done this way the record will not be deleted
		Optional<InstructorDetail> findById = instructorDetailRepository.findById(theId);
		if(findById.isPresent()) {
			Instructor theInstructor = findById.get().getInstructor();
			if(theInstructor != null) {
				theInstructor.setInstructorDetail(null);
			}
		}
		instructorDetailRepository.deleteById(theId);
	}

}
