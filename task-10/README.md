# Task 10 - Continuous Testing in Jenkins

`Jenkinsfile` makes unit tests an unconditional quality gate and puts the opt-in Selenium suite before packaging/deployment. A failed test exits Maven non-zero, so later stages do not run. It publishes JUnit XML and archives any real Selenium failure screenshots.

## Reproduce

1. Create a Pipeline job with `task-10/Jenkinsfile` as Script Path.
2. Run normally to execute unit tests; select `RUN_SELENIUM` only on an agent configured with a reachable Selenium endpoint and application URL.
3. Use the immutable evidence branches documented below to demonstrate one failed and one successful run.

## Jenkins evidence

Jenkins cannot fetch a raw commit SHA as a branch specifier. The following new branches were created without moving any existing branch or tag:

| Branch | Commit | Jenkins build | Result |
|---|---|---:|---|
| `evidence/task10-defect` | `7196b261ddaeef38434ee9e57f7d0e46fedaaa0b` | #2 | Failed: the unit-test quality gate reports the intended `onlyAdminCanCompleteAcceptedRequest` failure. |
| `evidence/task10-fix` | `8a3ed64ef45ccb77bd0bebec51bc989c5f47a028` | #3 | Successful: all unit tests passed and the pipeline completed. |

The original red build #1 remains in Jenkins history. It was the first attempt using the raw defect SHA as the job branch specifier, so Git failed before the pipeline could fetch `Jenkinsfile` or execute tests (`couldn't find remote ref refs/heads/7196...`). Its console record is retained as `evidence/jenkins-defect-build-1-console.log`; it is not used as the failed-test proof.

Build #2 and #3 evidence is saved as `jenkins-defect-build-2-*` and `jenkins-fix-build-3-*` respectively (console log, Stage View, and Test Result).

## Deliverables checklist

- [x] Jenkins quality gate placed before packaging/deployment
- [x] JUnit and Selenium-screenshot artifact publication configured
- [x] Deliberate defect correction commits and local Maven evidence - see `evidence/defect-test.log` and `evidence/fix-test.log`
- [x] Failed/successful Jenkins pipeline evidence - defect build #2 and fix build #3, with real console, Stage View, and Test Result evidence
