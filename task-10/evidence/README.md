# Jenkins evidence to capture

## Task delivery report

**Delivered.** Jenkins continuous testing was proven with an intentional unit-test failure followed by a corrected successful run. Build #2 is the failed quality-gate proof, and build #3 is the passing rerun; corresponding logs, Stage View, and test-result evidence are stored in this task.

1. `failed-pipeline.log` / `failed-pipeline.png` — build stopped at **Unit test quality gate** after checking out the intentionally defective commit.
2. `fixed-pipeline.log` / `successful-rerun.png` — successful rerun after the correction commit.
3. `junit-report.png` — Jenkins-published test report.

The supplied local Maven logs in this task only establish the real defect/fix test results; they are not represented as Jenkins runs.
