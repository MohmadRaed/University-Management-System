package com.dzl1f2.university.repository;

    import com.dzl1f2.university.entity.Student;
    import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
