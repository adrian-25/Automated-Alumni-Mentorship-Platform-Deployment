package com.adrian.mentorship.student;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
@Controller
public class StudentController {
    private final StudentRepository students;
    public StudentController(StudentRepository students) { this.students = students; }
    @GetMapping("/students") String list(@RequestParam(required = false) String query, Model model) {
        model.addAttribute("students", query == null || query.isBlank() ? students.findAll() : students.findByNameContainingIgnoreCaseOrCourseContainingIgnoreCase(query, query));
        model.addAttribute("query", query == null ? "" : query); return "students/list";
    }
    @GetMapping("/students/new") String newForm(Model model) { model.addAttribute("student", new Student()); return "students/form"; }
    @GetMapping("/students/{id}/edit") String edit(@PathVariable Long id, Model model) { model.addAttribute("student", students.findById(id).orElseThrow()); return "students/form"; }
    @PostMapping("/students") String save(@Valid @ModelAttribute Student student, BindingResult errors) { if (errors.hasErrors()) return "students/form"; students.save(student); return "redirect:/students"; }
}
