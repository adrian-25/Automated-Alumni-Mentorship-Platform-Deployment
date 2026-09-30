package com.adrian.mentorship.request;
import com.adrian.mentorship.alumni.AlumniRepository;
import com.adrian.mentorship.student.StudentRepository;
import java.util.EnumSet;
import org.springframework.stereotype.Service;

@Service
public class MentorshipRequestService {
    private final MentorshipRequestRepository requests; private final StudentRepository students; private final AlumniRepository alumni;
    public MentorshipRequestService(MentorshipRequestRepository requests, StudentRepository students, AlumniRepository alumni) { this.requests = requests; this.students = students; this.alumni = alumni; }
    public MentorshipRequest create(Long studentId, Long alumniId, String message) {
        var request = new MentorshipRequest(); request.setStudent(students.findById(studentId).orElseThrow()); request.setAlumni(alumni.findById(alumniId).orElseThrow()); request.setMessage(message); return requests.save(request);
    }
    public MentorshipRequest changeStatus(Long id, RequestStatus target, UserRole role) {
        var request = requests.findById(id).orElseThrow();
        if (!isAllowed(request.getStatus(), target, role)) throw new IllegalArgumentException("The selected role cannot make that status transition.");
        request.setStatus(target); request.touch(); return requests.save(request);
    }
    boolean isAllowed(RequestStatus current, RequestStatus target, UserRole role) {
        return current == RequestStatus.REQUESTED && role == UserRole.ALUMNI && EnumSet.of(RequestStatus.ACCEPTED, RequestStatus.REJECTED).contains(target)
                || current == RequestStatus.ACCEPTED && role == UserRole.ALUMNI && target == RequestStatus.COMPLETED;
    }
}
