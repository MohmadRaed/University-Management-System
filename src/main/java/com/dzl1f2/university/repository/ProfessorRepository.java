package com.dzl1f2.university.repository;

import com.dzl1f2.university.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}