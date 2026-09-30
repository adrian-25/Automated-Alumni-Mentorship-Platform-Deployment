package com.adrian.mentorship.alumni;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumniRepository extends JpaRepository<Alumni, Long> {
    List<Alumni> findByNameContainingIgnoreCaseOrExpertiseContainingIgnoreCase(String name, String expertise);
}
