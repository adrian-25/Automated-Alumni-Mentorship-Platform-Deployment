package com.adrian.mentorship;

import com.adrian.mentorship.alumni.Alumni;
import com.adrian.mentorship.alumni.AlumniRepository;
import com.adrian.mentorship.request.MentorshipRequest;
import com.adrian.mentorship.request.MentorshipRequestRepository;
import com.adrian.mentorship.request.RequestStatus;
import com.adrian.mentorship.student.Student;
import com.adrian.mentorship.student.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class DemoDataInitializer {

    @Bean
    CommandLineRunner seedDemoData(
            AlumniRepository alumniRepository,
            StudentRepository studentRepository,
            MentorshipRequestRepository requestRepository) {
        return args -> {
            if (alumniRepository.count() != 0 || studentRepository.count() != 0 || requestRepository.count() != 0) {
                return;
            }

            Alumni aarav = alumniRepository.save(alumni("Aarav Iyer", "aarav.iyer@example.test", "Vertex Cloud Labs Pvt Ltd", "Cloud and DevOps", 2018));
            Alumni meera = alumniRepository.save(alumni("Meera Nair", "meera.nair@example.test", "BrightPath Analytics", "Data Engineering", 2019));
            Alumni kabir = alumniRepository.save(alumni("Kabir Shah", "kabir.shah@example.test", "PixelForge Studios", "Product Design", 2020));

            Student riya = studentRepository.save(student("Riya Kapoor", "riya.kapoor@example.test", "Computer Science and Engineering", 2027));
            Student dev = studentRepository.save(student("Dev Malhotra", "dev.malhotra@example.test", "Information Technology", 2026));
            Student sara = studentRepository.save(student("Sara Khan", "sara.khan@example.test", "Data Science", 2027));
            studentRepository.save(student("Nisha Rao", "nisha.rao@example.test", "Electronics and Communication Engineering", 2026));
            studentRepository.save(student("Arjun Verma", "arjun.verma@example.test", "Computer Science and Engineering", 2025));
            studentRepository.save(student("Kavya Menon", "kavya.menon@example.test", "Artificial Intelligence and Machine Learning", 2027));
            studentRepository.save(student("Ishaan Gupta", "ishaan.gupta@example.test", "Information Technology", 2026));
            studentRepository.save(student("Ananya Das", "ananya.das@example.test", "Cyber Security", 2027));

            requestRepository.save(request(riya, aarav, "I need guidance on Docker, Kubernetes, and building a DevOps deployment pipeline.", RequestStatus.COMPLETED));
            requestRepository.save(request(dev, meera, "I would like mentorship on data engineering, portfolio projects, and preparing for internships.", RequestStatus.ACCEPTED));
            requestRepository.save(request(sara, kabir, "I want feedback on my product-design case study and portfolio presentation.", RequestStatus.REJECTED));
        };
    }

    private Alumni alumni(String name, String email, String company, String expertise, int graduationYear) {
        Alumni alumni = new Alumni();
        alumni.setName(name);
        alumni.setEmail(email);
        alumni.setCompany(company);
        alumni.setExpertise(expertise);
        alumni.setGraduationYear(graduationYear);
        return alumni;
    }

    private Student student(String name, String email, String course, int graduationYear) {
        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        student.setCourse(course);
        student.setGraduationYear(graduationYear);
        return student;
    }

    private MentorshipRequest request(Student student, Alumni alumni, String message, RequestStatus status) {
        MentorshipRequest request = new MentorshipRequest();
        request.setStudent(student);
        request.setAlumni(alumni);
        request.setMessage(message);
        request.setStatus(status);
        return request;
    }
}
