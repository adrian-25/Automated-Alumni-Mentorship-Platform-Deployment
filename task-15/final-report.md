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

## Final verification update

The live Jenkins testing job now has a real failed-test build (#2 on `evidence/task10-defect` at `7196b261ddaeef38434ee9e57f7d0e46fedaaa0b`) and a real successful build (#3 on `evidence/task10-fix` at `8a3ed64ef45ccb77bd0bebec51bc989c5f47a028`). Stage View, JUnit Test Result, and console records are committed under Task 10. The earlier red build #1 is retained as evidence of the failed raw-SHA branch attempt; Git cannot fetch a raw SHA as `refs/heads/<sha>`.

The Task 11 container was also verified in a real browser at `http://localhost:8081/alumni-mentorship/`; its dashboard screenshot is committed. Jenkins now has a Docker client and can talk to the mounted Docker socket, but this container-local setup is transient if the Jenkins container is recreated. Docker Hub publication and the clean target-host applies are not claimed because this session has no Docker Hub credentials and no supplied target host.

Task 3 also has a native Windows verification: Java 17 and Maven 3.10 completed `mvn verify` and packaged the WAR. The first `clean` encountered a Windows lock on `app/target`; rerunning the non-destructive `verify` lifecycle completed successfully.

Operational issues resolved during the project were: the first CI build used the wrong repository URL; Maven was initially absent inside Jenkins; the Maven 3.9.9 tool was selected for reproducible Java 17 builds; Task 8's default Tomcat webapps path did not exist and was replaced by `/tomcat_webapps`; and the Ansible INI environment placeholders were replaced with generated temporary inventories.
