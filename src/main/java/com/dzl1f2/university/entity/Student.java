package com.dzl1f2.university.entity;

import jakarta.persistence.*;   //imports a JPA annotation for the entity id and relations

import java.util.Set;   //allows the use of a set collection  for many to many relationship

@Entity     // tells spring boot that this class is a database table
public class Student {

    @Id     //// makes this field a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //makes the database generate id value and auto increments it

    private Long id;

    private String firstName;       //first name

    private String lastName;        // last name

    private String email;//         //student email



@ManyToMany     //many to many makes the students register in multiple cpurses
                // course can have many students

@JoinTable(     //join table  creates an extra table to connect students and courses

        name = "student_course",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
)
    private Set<Course> courses;    // Sets the collection of courses
                                    //each student can have multiple courses

@OneToOne(mappedBy = "student")     // one to one and the students have one profile
    private StudentProfile studentProfile;      //mappedBy = student means the student profile
                                                // entity owns the relationship
                                                //avoids creating duplicate foreign keys


        // Added getter and setter because spring boot uses them to read json data
        // and update fields as well as return json responses

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

        }
