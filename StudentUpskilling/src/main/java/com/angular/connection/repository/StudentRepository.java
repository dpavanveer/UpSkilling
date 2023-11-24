package com.angular.connection.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.angular.connection.model.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, Integer>{


}
