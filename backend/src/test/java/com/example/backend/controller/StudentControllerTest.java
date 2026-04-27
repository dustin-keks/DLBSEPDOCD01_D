package com.example.backend.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.backend.entity.Student;
import com.example.backend.entity.Studienkurs;
import com.example.backend.repository.StudentRepository;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentController studentController;

    @Test
    void getAllStudents_returnsListOfStudents() {
        Studienkurs studienkurs = new Studienkurs();
        studienkurs.setId(101L);
        studienkurs.setName("Test Studienkurs");
        studienkurs.setKuerzel("abc");

        Student student = new Student();
        student.setId(102L);
        student.setName("Max Mustermann");
        student.setStudienkurs(studienkurs);

        when(studentRepository.findAll()).thenReturn(List.of(student));

        List<Student> result = studentController.getAllStudents();

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getName()).isEqualTo("Max Mustermann");
        assertThat(result.get(0).getStudienkurs().getKuerzel()).isEqualTo("abc");
    }

    @Test
    void getStudentById_returnsStudent() {
        Student student = new Student();
        student.setId(103L);
        student.setName("John Doe");

        when(studentRepository.findById(103L)).thenReturn(Optional.of(student));

        Student result = studentController.getStudentById(103L);

        assertThat(result.getId()).isEqualTo(103L);
        assertThat(result.getName()).isEqualTo("John Doe");
    }

    @Test
    void getStudentById_throwsExceptionWhenNotFound() {
        when(studentRepository.findById(200L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> studentController.getStudentById(200L)).isInstanceOf(NoSuchElementException.class);
    }
}
