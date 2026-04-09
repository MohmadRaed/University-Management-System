package com.dzl1f2.university.controller;

import com.dzl1f2.university.entity.Course;
import com.dzl1f2.university.repository.CourseRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // GET all courses
    @GetMapping
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // GET course by id
    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    // CREATE course
    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }

    // UPDATE course
    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course updatedCourse) {

        Course course = courseRepository.findById(id).orElse(null);

        if (course != null) {

            course.setCourseName(updatedCourse.getCourseName());
            course.setCourseCode(updatedCourse.getCourseCode());

            return courseRepository.save(course);
        }

        return null;
    }

    // DELETE course
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseRepository.deleteById(id);
    }
}