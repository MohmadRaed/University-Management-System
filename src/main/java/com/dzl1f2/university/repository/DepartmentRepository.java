package com.dzl1f2.university.repository;

import com.dzl1f2.university.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}