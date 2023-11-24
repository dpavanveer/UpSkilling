////package com.angular.connection;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.Mockito.*;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.ArgumentMatchers;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import com.angular.connection.controller.StudentController;
//import com.angular.connection.model.Student;
//import com.angular.connection.service.StudentService;
//
//public class StudentControllerTest {
//
//    @Test
//    public void testGetAllStudents() {
//        // Arrange
//        StudentService studentService = mock(StudentService.class);
//        List<Student> expectedStudents = Arrays.asList(new Student(1, "John Doe", null, 0), new Student(2, "Jane Doe", null, 0));
//        when(studentService.getAllStudents()).thenReturn(expectedStudents);
//
//        StudentController studentController = new StudentController();
//        studentController.setStudentService(studentService);
//
//        // Act
//        List<Student> result = studentController.getAllStudents();
//
//        // Assert
//        assertEquals(expectedStudents, result);
//    }
//
//    @Test
//    public void testAddNewStudent() {
//        // Arrange
//        StudentService studentService = mock(StudentService.class);
//        Student inputStudent = new Student(1, "John Doe", null, 0);
//        when(studentService.addNewStudent(inputStudent)).thenReturn(inputStudent);
//
//        StudentController studentController = new StudentController();
//        studentController.setStudentService(studentService);
//
//        // Act
//        Student result = studentController.addNewStudent(inputStudent);
//
//        // Assert
//        assertNotNull(result);
//        assertEquals(inputStudent, result);
//    }
//
//    @Test
//    public void testGetStudentById() {
//        // Arrange
//        StudentService studentService = mock(StudentService.class);
//        int studentId = 1;
//        Student expectedStudent = new Student(studentId, "John Doe", null, studentId);
//        when(studentService.getStudentById(studentId)).thenReturn(expectedStudent);
//
//        StudentController studentController = new StudentController();
//        studentController.setStudentService(studentService);
//
//        // Act
//        Student result = studentController.getStudentById(studentId);
//
//        // Assert
//        assertNotNull(result);
//        assertEquals(expectedStudent, result);
//    }
//
//    @Test
//    public void testUpdateStudent() {
//        // Arrange
//        StudentService studentService = mock(StudentService.class);
//        int studentId = 1;
//        Student inputStudent = new Student(studentId, "Updated John Doe", null, studentId);
//        when(studentService.updateStudent(studentId, inputStudent)).thenReturn(inputStudent);
//
//        StudentController studentController = new StudentController();
//        studentController.setStudentService(studentService);
//
//        // Act
//        Student result = studentController.updateStudent(studentId, inputStudent);
//
//        // Assert
//        assertNotNull(result);
//        assertEquals(inputStudent, result);
//    }
//
//    @Test
//    public void testDeleteStudentById() {
//        // Arrange
//        StudentService studentService = mock(StudentService.class);
//        int studentId = 1;
//
//        StudentController studentController = new StudentController();
//        studentController.setStudentService(studentService);
//
//        // Act
//        studentController.deleteStudentById(studentId);
//
//        // Assert
//        verify(studentService, times(1)).deleteStudentById(studentId);
//    }
//}
