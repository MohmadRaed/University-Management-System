package com.dzl1f2.university.controller;

import com.dzl1f2.university.entity.Student;
import com.dzl1f2.university.repository.StudentRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentPageController {

    private final StudentRepository studentRepository;

    public StudentPageController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/students-page")
    public String studentsPage(Model model){

        model.addAttribute(
                "students",
                studentRepository.findAll()
        );

        return "students";
    }

    @PostMapping("/students-page/add")
    public String addStudent(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String email
    ){

        Student student = new Student();

        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);

        studentRepository.save(student);

        return "redirect:/students-page";
    }
}