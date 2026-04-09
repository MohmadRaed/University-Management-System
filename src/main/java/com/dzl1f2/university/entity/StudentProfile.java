package com.dzl1f2.university.entity;

import jakarta.persistence.*;

@Entity         //tells spring boot, this class became a database

public class StudentProfile {
    @Id     // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //id auto increments
    private Long id;
    private String address;
    private String phoneNumber;             // databases columns
    private String dateOfBirth;

    @OneToOne           //one to one relationship
    @JoinColumn(name = "student_id")        // creates foreign key for student profile
    private Student student;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}

// The database result will be
//  | id | address | phone number | date of birth | student id
// the student id connects the profile to the student