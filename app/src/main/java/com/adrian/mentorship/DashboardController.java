package com.adrian.mentorship;
import com.adrian.mentorship.alumni.AlumniRepository;
import com.adrian.mentorship.request.*;
import com.adrian.mentorship.student.StudentRepository;
import java.util.Arrays;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
class DashboardController {
    private final AlumniRepository alumni; private final StudentRepository students; private final MentorshipRequestRepository requests;
    DashboardController(AlumniRepository alumni, StudentRepository students, MentorshipRequestRepository requests) { this.alumni = alumni; this.students = students; this.requests = requests; }
    @GetMapping("/") String dashboard(Model model) { model.addAttribute("alumniCount", alumni.count()); model.addAttribute("studentCount", students.count()); model.addAttribute("requestCount", requests.count()); model.addAttribute("statuses", Arrays.stream(RequestStatus.values()).map(status -> new StatusTotal(status, requests.countByStatus(status))).toList()); return "dashboard"; }
    record StatusTotal(RequestStatus status, long count) {}
}
@RestController
class HealthController { @GetMapping("/api/health") java.util.Map<String, String> health() { return java.util.Map.of("status", "UP"); } }
