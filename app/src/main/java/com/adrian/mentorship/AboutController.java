package com.adrian.mentorship;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class AboutController {
    private static final String REPOSITORY = "https://github.com/adrian-25/Automated-Alumni-Mentorship-Platform-Deployment";

    @GetMapping("/about")
    String about(Model model) {
        model.addAttribute("repository", REPOSITORY);
        model.addAttribute("tasks", List.of(
                task(1, "Problem definition and scope"),
                task(2, "Agile planning and DevOps workflow"),
                task(3, "Requirements, architecture, and technology setup"),
                task(4, "Git and GitHub repository initialization"),
                task(5, "Feature development with branching"),
                task(6, "MVP completion and Git collaboration"),
                task(7, "Jenkins installation and CI job"),
                task(8, "Pipeline as code and server deployment"),
                task(9, "Selenium test design and local execution"),
                task(10, "Continuous testing in Jenkins"),
                task(11, "Docker image and container lifecycle"),
                task(12, "Jenkins-Docker continuous deployment"),
                task(13, "Ansible configuration management"),
                task(14, "Automated provisioning and reliability validation"),
                task(15, "Final release, documentation, and viva")));
        return "about";
    }

    private TaskReport task(int number, String title) {
        return new TaskReport(number, title, REPOSITORY + "/blob/main/task-" + number + "/evidence/README.md");
    }

    record TaskReport(int number, String title, String reportUrl) { }
}
