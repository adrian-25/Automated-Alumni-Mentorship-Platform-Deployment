package com.adrian.mentorship.alumni;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AlumniController {
    private final AlumniRepository alumniRepository;
    public AlumniController(AlumniRepository alumniRepository) { this.alumniRepository = alumniRepository; }

    @GetMapping("/alumni")
    String list(@RequestParam(required = false) String query, Model model) {
        var alumni = query == null || query.isBlank() ? alumniRepository.findAll()
                : alumniRepository.findByNameContainingIgnoreCaseOrExpertiseContainingIgnoreCase(query, query);
        model.addAttribute("alumni", alumni);
        model.addAttribute("query", query == null ? "" : query);
        return "alumni/list";
    }

    @GetMapping("/alumni/new")
    String newForm(Model model) { model.addAttribute("alumnus", new Alumni()); return "alumni/form"; }

    @GetMapping("/alumni/{id}/edit")
    String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("alumnus", alumniRepository.findById(id).orElseThrow());
        return "alumni/form";
    }

    @PostMapping("/alumni")
    String save(@Valid @ModelAttribute("alumnus") Alumni alumnus, BindingResult errors) {
        if (errors.hasErrors()) return "alumni/form";
        alumniRepository.save(alumnus);
        return "redirect:/alumni";
    }
}
