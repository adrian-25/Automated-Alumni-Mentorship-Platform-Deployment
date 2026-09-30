# Task 6 — MVP Completion and Git Collaboration

## MVP delivered

- Student profile create/list/edit/search
- Alumni profile create/list/edit/search
- Mentorship request creation and display
- Role-aware workflow: `REQUESTED → ACCEPTED|REJECTED` by Alumni; `ACCEPTED → COMPLETED` by Admin
- Dashboard totals and status breakdown
- `/api/health` and Actuator health endpoints
- Unit tests for the status-transition policy

## Reproduce

Run `cd app; mvn clean test spring-boot:run`, then use `http://localhost:8080`. Create a student and alumnus, create a request, select the Alumni role to accept/reject it, or Admin to complete an accepted request.

## Deliverables checklist

- [x] Functional MVP source implementation
- [x] Second feature branch (`feature/mvp-workflow`)
- [x] Unit tests for role/status rules
- [x] Real merge conflict created and resolved for `spring.application.name` — see `evidence/merge-conflict.log`
- [x] Pull request #2 reviewed and merged into `develop` — see `evidence/pr-merged.json`
- [ ] Release tag and promotion to `main` — pending completion in this task
- [x] Build/test log: 3 JUnit tests pass in the Java 17/Maven container (`evidence/maven-test.log`)
