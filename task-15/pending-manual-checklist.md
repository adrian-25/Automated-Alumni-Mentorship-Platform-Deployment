# Final pending-manual checklist

| Task | Item still to capture or perform |
|---|---|
| 12 | Completed: Jenkins CD build #12 passed 7 tests, deployed `adrian255/alumni-mentorship:12-47bbf33` locally, and passed the Docker health gate. The registry tags required for VM automation are `1-bd157e6` and `v1.0.0`. |
| 13 | Completed on the local VirtualBox Ubuntu target: dry-run and apply using `adrian255/alumni-mentorship:1-bd157e6`; the deployed health endpoint reports `UP`. |
| 14 | Completed: first apply, a second converged apply (`changed=0`), health validation, and rollback to `adrian255/alumni-mentorship:v1.0.0` completed on the VirtualBox Ubuntu target on 12 October 2026. |
| 15 | Capture the final live Jenkins-to-registry-to-target demonstration, record the required video, and complete the viva. The exported presentation is available at `deliverables/alumni-mentorship-devops-presentation.pptx`. |

Completed live evidence: Task 3 native Java/Maven verification, Task 4 GitHub issues, Task 7 CI, Task 8 Tomcat pipeline/deployment, Task 9 Selenium suite, Task 10 failed/fixed Jenkins testing builds, Task 11 running-container browser view, Task 12 Jenkins Docker CD, Task 13 VM apply, and Task 14 idempotency, rollback, and health verification.
