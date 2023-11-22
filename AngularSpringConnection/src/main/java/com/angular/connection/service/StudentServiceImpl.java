package com.angular.connection.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		 Optional<Student> findById = studentRepository.findById(id);
		 return findById.get();
	}


	@Override
	public Student updateStudent(int id, Student student) {
		Optional<Student> findById = studentRepository.findById(id);
		if(findById.isPresent()) {
			studentRepository.save(student);
		}
		return student;		
	}

	@Override
	public void deleteStudentById(int id) {
		studentRepository.deleteById(id);
		
	}





}
