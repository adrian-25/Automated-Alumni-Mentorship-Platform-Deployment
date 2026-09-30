# Task 9 — Selenium Test Design and Local Execution

Four critical end-to-end journeys are specified in [test-plan.md](test-plan.md) and implemented in `app/src/test/java/com/adrian/mentorship/e2e/`. Tests use a remote Chrome WebDriver and save a PNG whenever a test fails. They are opt-in via `RUN_SELENIUM=true` so unit builds do not require a browser.

## Deliverables checklist

- [x] Four critical journeys with assertions and deterministic test data
- [x] Selenium WebDriver tests and failure-screenshot mechanism
- [x] Container-based execution instructions
- [ ] Local browser-suite report/screenshots — pending completion in this task
