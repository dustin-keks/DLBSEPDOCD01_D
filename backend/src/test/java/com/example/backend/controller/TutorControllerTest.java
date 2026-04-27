package com.example.backend.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.backend.entity.Tutor;
import com.example.backend.repository.TutorRepository;

@ExtendWith(MockitoExtension.class)
public class TutorControllerTest {
    @Mock
    private TutorRepository tutorRepository;

    @InjectMocks
    private TutorController tutorController;

    @Test
    void getAllTutors_returnsListOfTutors() {
        Tutor tutor = new Tutor();
        tutor.setId(100L);
        tutor.setName("Test Tutor");
        tutor.setEmail("tutor@test.de");

        when(tutorRepository.findAll()).thenReturn(List.of(tutor));

        List<Tutor> result = tutorController.getAllTutors();

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getName()).isEqualTo("Test Tutor");
    }
}
