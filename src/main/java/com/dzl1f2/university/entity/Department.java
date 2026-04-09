package com.dzl1f2.university.entity;

    import jakarta.persistence.*;
    import java.util.Set;

    @Entity

public class Department {

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String building;

        @OneToMany(mappedBy = "department")
        private Set<Course> courses;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBuilding() {
            return building;
        }

        public void setBuilding(String building) {
            this.building = building;
        }

        public Set<Course> getCourses() {
            return courses;
        }

        public void setCourses(Set<Course> courses) {
            this.courses = courses;
        }
    }
