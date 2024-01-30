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

public class SubjectController {
@Autowired
SubjectRepo subjectRepo;
@PostMapping("/api/subject")
public ResponseEntity<Subject>saveSubject(@RequestBody Subject subject){
Subject savedSubject=subjectRepo.save(subject);
return new ResponseEntity<Subject>(savedSubject,HttpStatus.CREATED);
}
@GetMapping("/api/subject")
public ResponseEntity<List<Subject>> getAllSubjects(){
	List<Subject> subjects=subjectRepo.findAll();
	return new ResponseEntity<List<Subject>>(subjects,HttpStatus.OK);
}
@GetMapping("/api/subject/{id}")
public ResponseEntity<Subject> getSubjectById(@PathVariable int id){
	Optional<Subject> subject=subjectRepo.findById(id);
	if(subject.isPresent()) {
		return new ResponseEntity<Subject>(subject.get(),HttpStatus.OK);
	}
	else {
		return new ResponseEntity<Subject>(HttpStatus.NOT_FOUND);
	}
}
@PutMapping("/api/subject/{id}")
public ResponseEntity<Subject> updateSubject(@PathVariable int id,@RequestBody Subject updatedSubject){
	Optional<Subject> existingSubject=subjectRepo.findById(id);
	if(existingSubject.isPresent()) {
		Subject subject=existingSubject.get();
		subject.setName(updatedSubject.getName());
		Subject savedSubject=subjectRepo.save(subject);
		return new ResponseEntity<Subject>(savedSubject,HttpStatus.OK);
	}
	else {
		return new ResponseEntity<Subject>(HttpStatus.NOT_FOUND);
	}
}
@DeleteMapping("/api/subject/{id}")
public ResponseEntity<Void> deleteSubject(@PathVariable int id){
	Optional<Subject> subject=subjectRepo.findById(id);
	if(subject.isPresent()) {
		
		 subjectRepo.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	else {
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}

}

