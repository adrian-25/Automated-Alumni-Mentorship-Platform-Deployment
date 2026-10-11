# Final pending-manual checklist

| Task | Item still to capture or perform |
|---|---|
| 12 | Create Jenkins credential `dockerhub-credentials`, set `DOCKERHUB_REPOSITORY=adrian255/alumni-mentorship`, and capture the real Jenkins CD run. Docker Hub image `adrian255/alumni-mentorship:1-bd157e6` is already published. |
| 13 | Completed on the local VirtualBox Ubuntu target: dry-run and apply using `adrian255/alumni-mentorship:1-bd157e6`; the deployed health endpoint reports `UP`. |
| 14 | First apply, health, and rollback plumbing completed on the target. Rerun with `PreviousStableImage "adrian255/alumni-mentorship:v1.0.0"` and capture one second apply with `changed=0` for complete idempotency and real-version rollback evidence. |
| 15 | Capture the final live Jenkins-to-registry-to-target demonstration, record the required video, and complete the viva. The exported presentation is available at `deliverables/alumni-mentorship-devops-presentation.pptx`. |

Completed live evidence: Task 3 native Java/Maven verification, Task 4 GitHub issues, Task 7 CI, Task 8 Tomcat pipeline/deployment, Task 9 Selenium suite, Task 10 failed/fixed Jenkins testing builds, Task 11 running-container browser view, Task 12 Docker Hub publication, Task 13 VM apply, and Task 14 rollback/health verification.
