# Task 1 — Problem Definition and Scope

## Problem statement

Universities often rely on informal spreadsheets, social-media groups, and personal introductions to connect students with alumni. This makes it difficult for students to find relevant mentors, for alumni to manage requests, and for administrators to see whether mentoring is actually happening. The **Automated Alumni Mentorship Platform** is a small web application that provides a single, auditable workflow for discovering alumni mentors and managing mentorship requests.

## Target users and pain points

| User | Need | Current pain point |
|---|---|---|
| Student | Find a suitable alumnus and request guidance | No searchable, structured mentor directory or request tracking |
| Alumni | View and respond to requests | Requests arrive across untracked channels and lack context |
| Administrator | Govern records and monitor outcomes | No consolidated view of users, requests, or their status |

## Stakeholders

- Students and student-placement cell
- Alumni mentors
- Department faculty and alumni-relations team
- Platform administrator / project maintainer
- Course evaluator

## Objectives and measurable success criteria

| Objective | Success criterion |
|---|---|
| Centralize mentor data | Admin can create, view, edit, and search alumni and student records |
| Make requests traceable | A request records student, alumni, message, and a valid status transition |
| Enable mentorship workflow | Alumni can accept or reject a requested mentorship; accepted requests can be completed |
| Give administrators visibility | Dashboard shows totals by entity and request status |
| Make deployment repeatable | Maven, Jenkins, Docker, and Ansible assets can reproduce a build and deployment |

## Constraints and assumptions

- MVP uses Java 17, Spring Boot, Thymeleaf, Maven, and an embedded H2 database.
- The deployment target is a Tomcat-compatible WAR; Docker provides a repeatable runtime path.
- Authentication is intentionally lightweight for the course MVP: a selected role is supplied in the request/UI rather than a production identity provider.
- No real alumni/student personal data or secrets are committed.
- External services (Jenkins server, registry credentials, remote Ansible host) require local/manual configuration.

## Frozen 15-task MVP scope

Included: alumni and student profile CRUD, search, mentorship request creation/view/update, role-based status transitions (`REQUESTED → ACCEPTED → COMPLETED` or `REQUESTED → REJECTED`), an administrative summary dashboard, unit/UI tests, CI/CD configuration, containerization, and Ansible provisioning.

Excluded: SSO, email/SMS notifications, calendar booking, payments, file sharing, recommendation algorithms, production-grade authorization, and a managed cloud database.

## Deliverables checklist

- [x] Problem statement and real-world context
- [x] Target users, pain points, and stakeholders
- [x] Objectives and measurable criteria
- [x] Constraints and assumptions
- [x] Small MVP scope frozen across all 15 tasks
