package com.angular.connection;
import com.angular.connection.controller.StudentController;
import com.angular.connection.model.Student;
import com.angular.connection.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class StudentControllerTest {

    @Mock
    private StudentService studentService;

    @InjectMocks
    private StudentController studentController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
    }

    @Test
    void getAllStudents() throws Exception {
        // Arrange
        List<Student> students = Arrays.asList(
                new Student(1, "John", null, 0),
                new Student(2, "Jane", null, 0)
        );
        when(studentService.getAllStudents()).thenReturn(students);

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/employee/allStudents"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("John"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("Jane"));

        // Verify interactions
        verify(studentService, times(1)).getAllStudents();
        verifyNoMoreInteractions(studentService);
    }

    @Test
    void addNewStudent() throws Exception {
        // Arrange
        Student studentToAdd = new Student(3, "Bob", null, 0);
        when(studentService.addNewStudent(any(Student.class))).thenReturn(studentToAdd);

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/employee/addStudent")
                .content("{\"id\":3,\"name\":\"Bob\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(3))
                .andExpect(jsonPath("$.name").value("Bob"));

        // Verify interactions
        verify(studentService, times(1)).addNewStudent(any(Student.class));
        verifyNoMoreInteractions(studentService);
    }

    // Similar tests for getStudentById, updateStudent, and deleteStudentById
}
