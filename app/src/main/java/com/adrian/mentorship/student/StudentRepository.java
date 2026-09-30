package com.adrian.mentorship.student;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByNameContainingIgnoreCaseOrCourseContainingIgnoreCase(String name, String course);
}
