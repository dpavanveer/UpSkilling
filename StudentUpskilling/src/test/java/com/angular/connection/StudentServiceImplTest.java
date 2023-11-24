package com.angular.connection;

import com.angular.connection.model.Student;
import com.angular.connection.repository.StudentRepository;
import com.angular.connection.service.StudentServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class StudentServiceImplTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllStudents() {
        // Arrange
        List<Student> students = Arrays.asList(
                new Student(1, "John", null, 0),
                new Student(2, "Jane", null, 0)
        );
        when(studentRepository.findAll()).thenReturn(students);

        // Act
        List<Student> result = studentService.getAllStudents();

        // Assert
        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getName());
        assertEquals("Jane", result.get(1).getName());

        // Verify interactions
        verify(studentRepository, times(1)).findAll();
        verifyNoMoreInteractions(studentRepository);
    }

    @Test
    void testAddNewStudent() {
        // Arrange
        Student studentToAdd = new Student(3, "Bob", null, 0);
        when(studentRepository.insert(any(Student.class))).thenReturn(studentToAdd);

        // Act
        Student result = studentService.addNewStudent(studentToAdd);

        // Assert
        assertEquals(3, result.getId());
        assertEquals("Bob", result.getName());

        // Verify interactions
        verify(studentRepository, times(1)).insert(any(Student.class));
        verifyNoMoreInteractions(studentRepository);
    }

    @Test
    void testGetStudentById() {
        // Arrange
        Student existingStudent = new Student(4, "Alice", null, 0);
        when(studentRepository.findById(4)).thenReturn(Optional.of(existingStudent));

        // Act
        Student result = studentService.getStudentById(4);

        // Assert
        assertEquals(4, result.getId());
        assertEquals("Alice", result.getName());

        // Verify interactions
        verify(studentRepository, times(1)).findById(4);
        verifyNoMoreInteractions(studentRepository);
    }

    @Test
    void testUpdateStudent() {
        // Arrange
        Student updatedStudent = new Student(5, "UpdatedName", null, 0);
        when(studentRepository.findById(5)).thenReturn(Optional.of(updatedStudent));

        // Act
        Student result = studentService.updateStudent(5, updatedStudent);

        // Assert
        assertEquals(5, result.getId());
        assertEquals("UpdatedName", result.getName());

        // Verify interactions
        verify(studentRepository, times(1)).findById(5);
        verify(studentRepository, times(1)).save(updatedStudent);
        verifyNoMoreInteractions(studentRepository);
    }

    @Test
    void testDeleteStudentById() {
        // Arrange & Act
        studentService.deleteStudentById(6);

        // Verify interactions
        verify(studentRepository, times(1)).deleteById(6);
        verifyNoMoreInteractions(studentRepository);
    }
}
