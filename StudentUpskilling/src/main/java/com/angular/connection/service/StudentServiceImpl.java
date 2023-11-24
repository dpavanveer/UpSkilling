package com.angular.connection.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angular.connection.exception.ResourceNotFoundException;
import com.angular.connection.model.Student;
import com.angular.connection.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student addNewStudent(Student employee) {
		return studentRepository.insert(employee);
	}

	@Override
	public Student getStudentById(int id) {
		 Student student = studentRepository.findById(id).orElseThrow(
			() -> new ResourceNotFoundException("Student", "id",  id)
				 );
		 return (student);
	}


	@Override
	public Student updateStudent(int id, Student student) {
		
		Student existingstudent = studentRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Student", "id", id)
					 );
			 return (student);
		}
		
		

	@Override
	public void deleteStudentById(int id) {
		
		Student existingstudent = studentRepository.findById(id).orElseThrow(
	            () -> new ResourceNotFoundException("Student", "id", id)
						 );
		studentRepository.deleteById(id);
		
	}





}
