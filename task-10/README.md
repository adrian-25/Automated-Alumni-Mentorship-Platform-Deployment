# Task 10 — Continuous Testing in Jenkins

`Jenkinsfile` makes unit tests an unconditional quality gate and puts the opt-in Selenium suite before packaging/deployment. A failed test exits Maven non-zero, so later stages do not run. It publishes JUnit XML and archives any real Selenium failure screenshots.

## Reproduce

1. Create a Pipeline job with `task-10/Jenkinsfile` as Script Path.
2. Run normally to execute unit tests; select `RUN_SELENIUM` only on an agent configured with a reachable Selenium endpoint and application URL.
3. Use the defect/fix commits documented in this task to demonstrate one failed and one successful run.

## Deliverables checklist

- [x] Jenkins quality gate placed before packaging/deployment
- [x] JUnit and Selenium-screenshot artifact publication configured
- [x] Deliberate defect correction commits and local Maven evidence — see `evidence/defect-test.log` and `evidence/fix-test.log`
- [ ] Failed/successful Jenkins pipeline evidence — pending-manual (no Jenkins server)
