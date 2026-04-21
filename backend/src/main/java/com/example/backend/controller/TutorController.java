package com.example.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.entity.Tutor;
import com.example.backend.repository.TutorRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/tutoren")
public class TutorController {
    private final TutorRepository tutorRepository;

    public TutorController(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    @GetMapping
    public List<Tutor> getAllTutors() {
        return tutorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Tutor getTutorById(@PathVariable Long id) {
        return tutorRepository.findById(id).orElseThrow();
    }
}
