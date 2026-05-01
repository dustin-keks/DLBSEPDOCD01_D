package com.example.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.entity.Studienkurs;
import com.example.backend.repository.StudienkursRepository;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:30080"})
@RestController
@RequestMapping("/api/studienkurse")
public class StudienkursController {
    private final StudienkursRepository studienkursRepository;

    public StudienkursController(StudienkursRepository studienkursRepository) {
        this.studienkursRepository = studienkursRepository;
    }

    @GetMapping
    public List<Studienkurs> getAllStudienkurse() {
        return studienkursRepository.findAll();
    }

    @GetMapping("/{id}")
    public Studienkurs getStudienkursById(@PathVariable Long id) {
        return studienkursRepository.findById(id).orElseThrow();
    }
}
