# Task 5 — Feature Development with Branching

## First core workflow: Alumni directory

Implemented an alumni directory with create, list, edit, and name/expertise search. Input is validated on the server and persisted with Spring Data JPA/H2.

## Collaboration evidence

- Feature branch: `feature/alumni-directory`
- Pull request target: `develop`
- A review comment and merge evidence are recorded after the PR is created and merged.

## Reproduce

1. Install Java 17 and Maven.
2. Run `cd app; mvn spring-boot:run`.
3. Open `http://localhost:8080/alumni`, add a record, then search it by name or expertise.

## Deliverables checklist

- [x] Working first core feature on feature branch
- [x] Create, view, update, and search alumni profiles
- [x] Server-side validation
- [ ] PR review comment and merge into develop — pending completion in this task
- [x] Maven test executed in the official Java 17/Maven container; output in `evidence/maven-test.log`
