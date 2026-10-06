# Final pending-manual checklist

| Task | Item still to capture or perform |
|---|---|
| 4 | Create GitHub issues from the supplied templates. |
| 12 | Set `DOCKERHUB_USER` and `DOCKERHUB_TOKEN` in the execution environment; create Jenkins credential `dockerhub-credentials`; publish a versioned `adrian255/alumni-mentorship` image and capture the real CD run and Docker Hub tags. |
| 13 | Supply a clean reachable Linux host and SSH user; run the corrected temporary-inventory runner with `--check` and an apply using a published immutable image. |
| 14 | On that target, capture the first apply, second apply with `changed=0`, application health, and rollback to a previously published immutable tag. |
| 15 | Capture the final live Jenkins-to-registry-to-target demonstration, record the required video, export the presentation, and complete the viva. |

Completed live evidence: Task 3 native Java/Maven verification, Task 7 CI, Task 8 Tomcat pipeline/deployment, Task 9 Selenium suite, Task 10 failed/fixed Jenkins testing builds, and Task 11 running-container browser view.
