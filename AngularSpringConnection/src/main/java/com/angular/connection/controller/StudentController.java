package com.angular.connection.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.angular.connection.model.Student;
import com.angular.connection.repository.StudentRepository;
import com.angular.connection.service.StudentService;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/employee")
@CrossOrigin()
public class StudentController {
	
	  private static final Logger logger = (Logger) LoggerFactory.getLogger(StudentController.class);

	
	@Autowired
	private StudentService studentService;
	
	 @GetMapping("/allStudents")
	    public List<Student> getAllStudents() {
	        logger.info("Fetching all students");
	        return studentService.getAllStudents();
	    }

	
	 @PostMapping("/addStudent")
	    public Student addNewStudent(@RequestBody Student student) {
	        logger.info("Adding a new student: {}", student);
	        return studentService.addNewStudent(student);
	    }
	 
	  @GetMapping("/studentid/{id}")
	    public Student getStudentById(@PathVariable int id) {
	        logger.info("Fetching student by ID: {}", id);
	        return studentService.getStudentById(id);
	    }
	
	  @PutMapping("/updateStudent/{id}")
	    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
	        logger.info("Updating student with ID {}: {}", id, student);
	        return studentService.updateStudent(id, student);
	    }
	  

	  @DeleteMapping("/deleteStudent/{id}")
	    public void deleteStudentById(@PathVariable int id) {
	        logger.info("Deleting student with ID: {}", id);
	        studentService.deleteStudentById(id);
	    }

}
