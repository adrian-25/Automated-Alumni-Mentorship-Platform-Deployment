# Jenkins evidence to capture

1. `failed-pipeline.log` / `failed-pipeline.png` — build stopped at **Unit test quality gate** after checking out the intentionally defective commit.
2. `fixed-pipeline.log` / `successful-rerun.png` — successful rerun after the correction commit.
3. `junit-report.png` — Jenkins-published test report.

The supplied local Maven logs in this task only establish the real defect/fix test results; they are not represented as Jenkins runs.
