# Selenium test plan

| Journey | Assertion | Test method |
|---|---|---|
| Dashboard availability | Root page renders dashboard heading | `dashboardIsAvailable` |
| Profile onboarding | Student and alumni are saved; alumni search returns the expertise match | `studentAndAlumniCanBeCreatedAndSearched` |
| Alumni decision | A requested mentorship becomes `ACCEPTED` when submitted as `ALUMNI` | `requestedMentorshipCanBeAcceptedByAlumni` |
| Admin completion | An accepted mentorship becomes `COMPLETED` when submitted as `ADMIN` | `acceptedMentorshipCanBeCompletedByAdmin` |

The test class is ordered because it exercises the complete MVP journey using the H2 data created in the preceding step. It runs only when `RUN_SELENIUM=true`; ordinary unit-test builds remain browser-independent.

## Execute with containers

1. Start the application where Selenium can reach it, normally `http://host.docker.internal:8080` from the browser container.
2. Start Chrome: `docker run -d --name alumni-selenium -p 4444:4444 --shm-size=2g selenium/standalone-chrome:latest`.
3. Run Maven with `RUN_SELENIUM=true`, `SELENIUM_REMOTE_URL=http://localhost:4444`, and `APP_BASE_URL=http://host.docker.internal:8080`.
4. On failure, inspect `app/target/selenium-screenshots/` and archive the actual PNG in `task-9/evidence/`.
