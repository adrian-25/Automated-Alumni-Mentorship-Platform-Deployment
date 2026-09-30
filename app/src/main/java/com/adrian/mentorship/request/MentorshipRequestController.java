package com.adrian.mentorship.request;
import com.adrian.mentorship.alumni.AlumniRepository;
import com.adrian.mentorship.student.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MentorshipRequestController {
    private final MentorshipRequestRepository requests; private final MentorshipRequestService service; private final StudentRepository students; private final AlumniRepository alumni;
    public MentorshipRequestController(MentorshipRequestRepository requests, MentorshipRequestService service, StudentRepository students, AlumniRepository alumni) { this.requests = requests; this.service = service; this.students = students; this.alumni = alumni; }
    @GetMapping("/requests") String list(Model model) { model.addAttribute("requests", requests.findAll()); return "requests/list"; }
    @GetMapping("/requests/new") String newForm(Model model) { model.addAttribute("students", students.findAll()); model.addAttribute("alumni", alumni.findAll()); return "requests/form"; }
    @PostMapping("/requests") String create(@RequestParam Long studentId, @RequestParam Long alumniId, @RequestParam String message) { service.create(studentId, alumniId, message); return "redirect:/requests"; }
    @PostMapping("/requests/{id}/status") String status(@PathVariable Long id, @RequestParam RequestStatus status, @RequestParam UserRole role, Model model) {
        try { service.changeStatus(id, status, role); } catch (IllegalArgumentException exception) { model.addAttribute("error", exception.getMessage()); model.addAttribute("requests", requests.findAll()); return "requests/list"; }
        return "redirect:/requests";
    }
}
