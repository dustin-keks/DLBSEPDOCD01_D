package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.Tutor;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {

}
