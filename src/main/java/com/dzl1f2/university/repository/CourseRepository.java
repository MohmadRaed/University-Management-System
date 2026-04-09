package com.dzl1f2.university.repository;

import com.dzl1f2.university.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}