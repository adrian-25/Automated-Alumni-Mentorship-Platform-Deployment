package com.adrian.mentorship.request;
import com.adrian.mentorship.alumni.Alumni;
import com.adrian.mentorship.student.Student;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.Instant;

@Entity
public class MentorshipRequest {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @ManyToOne(optional = false) private Student student;
    @ManyToOne(optional = false) private Alumni alumni;
    @NotBlank @Column(length = 1000) private String message;
    @Enumerated(EnumType.STRING) private RequestStatus status = RequestStatus.REQUESTED;
    private Instant createdAt = Instant.now();
    private Instant updatedAt = Instant.now();
    public Long getId() { return id; } public Student getStudent() { return student; } public void setStudent(Student student) { this.student = student; }
    public Alumni getAlumni() { return alumni; } public void setAlumni(Alumni alumni) { this.alumni = alumni; }
    public String getMessage() { return message; } public void setMessage(String message) { this.message = message; }
    public RequestStatus getStatus() { return status; } public void setStatus(RequestStatus status) { this.status = status; }
    public Instant getCreatedAt() { return createdAt; } public Instant getUpdatedAt() { return updatedAt; }
    public void touch() { updatedAt = Instant.now(); }
}
