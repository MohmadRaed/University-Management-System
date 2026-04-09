package com.dzl1f2.university.controller;

import com.dzl1f2.university.entity.StudentProfile;
import com.dzl1f2.university.repository.StudentProfileRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student-profiles")
public class StudentProfileController {

    private final StudentProfileRepository studentProfileRepository;

    public StudentProfileController(StudentProfileRepository studentProfileRepository) {
        this.studentProfileRepository = studentProfileRepository;
    }

    @GetMapping
    public List<StudentProfile> getAllProfiles() {
        return studentProfileRepository.findAll();
    }

    @GetMapping("/{id}")
    public StudentProfile getProfileById(@PathVariable Long id) {
        return studentProfileRepository.findById(id).orElse(null);
    }

    @PostMapping
    public StudentProfile createProfile(@RequestBody StudentProfile profile) {
        return studentProfileRepository.save(profile);
    }

    @PutMapping("/{id}")
    public StudentProfile updateProfile(@PathVariable Long id, @RequestBody StudentProfile updatedProfile) {

        StudentProfile profile = studentProfileRepository.findById(id).orElse(null);

        if (profile != null) {

            profile.setAddress(updatedProfile.getAddress());
            profile.setPhoneNumber(updatedProfile.getPhoneNumber());
            profile.setDateOfBirth(updatedProfile.getDateOfBirth());

            return studentProfileRepository.save(profile);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteProfile(@PathVariable Long id) {
        studentProfileRepository.deleteById(id);
    }
}