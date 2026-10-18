# Manual evidence to capture

## Task delivery report

**Delivered.** Four Selenium end-to-end journeys and failure-screenshot support were implemented. The completed local run, including four browser journeys and three unit tests, is recorded in `selenium-run.log` and `surefire-reports/`; the notes below describe the retained raw artifacts.

- `selenium-report/` — Maven Surefire XML/HTML report from an actual run.
- `failure-<test>.png` — a screenshot created only if a browser test fails.
- `selenium-run.log` — actual Maven invocation output.

Failure screenshots are generated automatically at `app/target/selenium-screenshots/`; do not add placeholders with a `.png` extension.
