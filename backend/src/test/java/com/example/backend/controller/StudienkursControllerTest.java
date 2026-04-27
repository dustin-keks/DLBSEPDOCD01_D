package com.example.backend.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.backend.entity.Studienkurs;
import com.example.backend.entity.Tutor;
import com.example.backend.repository.StudienkursRepository;

@ExtendWith(MockitoExtension.class)
public class StudienkursControllerTest {
    @Mock
    private StudienkursRepository studienkursRepository;

    @InjectMocks
    private StudienkursController studienkursController;

    @Test
    void getAllStudienkurse_returnsListOfStudienkurse() {
        Tutor tutor = new Tutor();
        tutor.setId(104L);
        tutor.setName("Professor Snape");
        tutor.setEmail("snape@hogwarts.uk");

        Studienkurs studienkurs = new Studienkurs();
        studienkurs.setId(105L);
        studienkurs.setName("Zaubertränke");
        studienkurs.setKuerzel("ZT");
        studienkurs.setTutor(tutor);

        when(studienkursRepository.findAll()).thenReturn(List.of(studienkurs));

        List<Studienkurs> result = studienkursController.getAllStudienkurse();

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getKuerzel()).isEqualTo("ZT");
        assertThat(result.get(0).getTutor().getName()).isEqualTo("Professor Snape");
    }

    @Test
    void getStudienkursById_returnsStudienkurs() {
        Studienkurs studienkurs = new Studienkurs();
        studienkurs.setId(106L);
        studienkurs.setName("DevOps");
        studienkurs.setKuerzel("DO");

        when(studienkursRepository.findById(106L)).thenReturn(Optional.of(studienkurs));

        Studienkurs result = studienkursController.getStudienkursById(106L);

        assertThat(result.getId()).isEqualTo(106L);
        assertThat(result.getKuerzel()).isEqualTo("DO");
    }
}
