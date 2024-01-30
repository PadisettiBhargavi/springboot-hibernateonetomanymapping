package com.hibernateoneone;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ClassStudentController {
	@Autowired
	ClassStudentRepo classstudentRepo;
	@PostMapping("/api/classstudent")
	public ResponseEntity<ClassStudent>saveClassStudent(@RequestBody ClassStudent classstudent){
		ClassStudent savedClassStudent=classstudentRepo.save(classstudent);
	return new ResponseEntity<ClassStudent>(savedClassStudent,HttpStatus.CREATED);
	}
	@GetMapping("/api/classstudent")
	public ResponseEntity<List<ClassStudent>> getAllClassStudent(){
		List<ClassStudent> classstudents=classstudentRepo.findAll();
		return new ResponseEntity<List<ClassStudent>>(classstudents,HttpStatus.OK);
	}
	@GetMapping("/api/classstudent/{id}")
	public ResponseEntity<ClassStudent> getClassStudentById(@PathVariable int id){
		Optional<ClassStudent> ClassStudent=classstudentRepo.findById(id);
		if(ClassStudent.isPresent()) {
			return new ResponseEntity<ClassStudent>(ClassStudent.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<ClassStudent>(HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("/api/classstudent/{id}")
	public ResponseEntity<ClassStudent> updateClassStudent(@PathVariable int id,@RequestBody ClassStudent updatedClassStudent){
		Optional<ClassStudent> existingClassStudent=classstudentRepo.findById(id);
		if(existingClassStudent.isPresent()) {
			ClassStudent ClassStudent=existingClassStudent.get();

			ClassStudent.setName(updatedClassStudent.getName());
			ClassStudent.setDob(updatedClassStudent.getDob());
			ClassStudent.setClasses(updatedClassStudent.getClasses());
			ClassStudent.setDivision(updatedClassStudent.getDivision());
			ClassStudent.setGender(updatedClassStudent.getGender());
			ClassStudent savedClassStudent=classstudentRepo.save(ClassStudent);
			return new ResponseEntity<ClassStudent>(savedClassStudent,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<ClassStudent>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/api/classstudent/{id}")
	public ResponseEntity<Void> deleteClassStudent(@PathVariable int id){
		Optional<ClassStudent> ClassStudent=classstudentRepo.findById(id);
		if(ClassStudent.isPresent()) {
			
			classstudentRepo.deleteById(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

	}


	

