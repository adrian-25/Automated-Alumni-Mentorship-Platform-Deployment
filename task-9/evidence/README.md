# Manual evidence to capture

- `selenium-report/` — Maven Surefire XML/HTML report from an actual run.
- `failure-<test>.png` — a screenshot created only if a browser test fails.
- `selenium-run.log` — actual Maven invocation output.

Failure screenshots are generated automatically at `app/target/selenium-screenshots/`; do not add placeholders with a `.png` extension.
