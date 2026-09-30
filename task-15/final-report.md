# Final technical report

## Release summary

This repository delivers a compact Alumni Mentorship Platform with source-controlled application code in `app/` and task-by-task DevOps evidence in `task-1` through `task-15`. The MVP supports student/alumni records, search, mentorship requests, a role-aware status workflow, and a summary dashboard.

## Architecture

The Spring Boot 3 application is Java 17 and WAR-capable. Thymeleaf serves the MVC UI; Spring Data JPA persists to H2 for the MVP. It exposes `/api/health` and `/actuator/health`. Maven runs JUnit and Selenium tests. The deployment path is Maven WAR → Tomcat container; Jenkins pipelines implement CI/CD; Ansible configures a clean target and validates health.

## Verified local path

| Stage | Verified result |
|---|---|
| Source control | Feature PRs #1 and #2 were reviewed/merged; real conflict resolved; `v1.0.0` baseline tagged |
| Unit quality gate | 3 transition-policy tests passed |
| Browser quality gate | 4 remote-Chrome Selenium journeys passed, with failure screenshots enabled |
| Container build | `alumni-mentorship:v1.0.0` built from `task-11/Dockerfile` |
| Container runtime | Tomcat container returned HTTP 200 / `{"status":"UP"}` |
| Configuration syntax | Task 13 playbook and Task 14 rollback playbook passed Ansible syntax validation |

Actual console output and reports live in the relevant task `evidence/` directories; none are fabricated.

## Deployment operations

Use the Task 12 pipeline only on a Jenkins agent with Docker, the configured Jenkins credential ID, and an explicit Docker Hub repository. Use Task 13 against a dedicated Linux host over SSH, and pass the immutable image tag via `APP_IMAGE`. Run Task 14's second apply to confirm no drift, and keep a previously working immutable tag available for rollback.
