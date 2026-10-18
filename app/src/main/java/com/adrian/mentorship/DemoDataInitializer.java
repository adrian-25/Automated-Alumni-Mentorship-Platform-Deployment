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
            Alumni priya = alumniRepository.save(alumni("Priya Joshi", "priya.joshi@example.test", "Orbit Financial Systems", "Cyber Security", 2017));
            Alumni rahul = alumniRepository.save(alumni("Rahul Bose", "rahul.bose@example.test", "Northstar Digital", "Full-Stack Engineering", 2016));
            Alumni sneha = alumniRepository.save(alumni("Sneha Reddy", "sneha.reddy@example.test", "InsightWorks AI", "Machine Learning", 2019));
            Alumni vikram = alumniRepository.save(alumni("Vikram Singh", "vikram.singh@example.test", "Civic Tech Collective", "Software Architecture", 2015));
            Alumni neha = alumniRepository.save(alumni("Neha Kulkarni", "neha.kulkarni@example.test", "Studio Meridian", "UX Research", 2018));

            Student riya = studentRepository.save(student("Riya Kapoor", "riya.kapoor@example.test", "Computer Science and Engineering", 2027));
            Student dev = studentRepository.save(student("Dev Malhotra", "dev.malhotra@example.test", "Information Technology", 2026));
            Student sara = studentRepository.save(student("Sara Khan", "sara.khan@example.test", "Data Science", 2027));
            Student nisha = studentRepository.save(student("Nisha Rao", "nisha.rao@example.test", "Electronics and Communication Engineering", 2026));
            Student arjun = studentRepository.save(student("Arjun Verma", "arjun.verma@example.test", "Computer Science and Engineering", 2025));
            Student kavya = studentRepository.save(student("Kavya Menon", "kavya.menon@example.test", "Artificial Intelligence and Machine Learning", 2027));
            Student ishaan = studentRepository.save(student("Ishaan Gupta", "ishaan.gupta@example.test", "Information Technology", 2026));
            Student ananya = studentRepository.save(student("Ananya Das", "ananya.das@example.test", "Cyber Security", 2027));

            requestRepository.save(request(riya, aarav, "I need guidance on Docker, Kubernetes, and building a DevOps deployment pipeline.", RequestStatus.COMPLETED));
            requestRepository.save(request(dev, meera, "I would like mentorship on data engineering, portfolio projects, and preparing for internships.", RequestStatus.ACCEPTED));
            requestRepository.save(request(sara, kabir, "I want feedback on my product-design case study and portfolio presentation.", RequestStatus.REJECTED));
            requestRepository.save(request(nisha, priya, "I want to understand security reviews, threat modelling, and entry-level cyber security roles.", RequestStatus.REQUESTED));
            requestRepository.save(request(arjun, rahul, "I need help planning a full-stack capstone project and preparing for technical interviews.", RequestStatus.ACCEPTED));
            requestRepository.save(request(kavya, sneha, "I am looking for feedback on my machine-learning learning plan and project portfolio.", RequestStatus.REQUESTED));
            requestRepository.save(request(ishaan, vikram, "I would like advice on clean architecture and growing into a software architect role.", RequestStatus.REJECTED));
            requestRepository.save(request(ananya, neha, "I need guidance on conducting user research for a cyber-security product concept.", RequestStatus.COMPLETED));
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
