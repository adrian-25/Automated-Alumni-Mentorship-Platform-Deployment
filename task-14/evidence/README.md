# Reliability evidence

## Task delivery report

**Delivered.** Provisioning, a second idempotent apply, rollback to the prior stable image, and independent health validation all completed on the Ubuntu target. The concrete logs and recaps are listed below.

Live VirtualBox Ubuntu-target evidence is captured here:

- [`first-apply.log`](first-apply.log) — 12 October 2026 provisioning apply using `adrian255/alumni-mentorship:1-bd157e6`; health reported `UP` and the recap was `ok=10 changed=2 unreachable=0 failed=0`.
- [`idempotency-apply.log`](idempotency-apply.log) — second apply on the same target; the recap was `ok=10 changed=0 unreachable=0 failed=0`, confirming convergence without configuration drift.
- [`rollback.log`](rollback.log) — rollback to `adrian255/alumni-mentorship:v1.0.0`, followed by a passing health check and `ok=5 changed=1 unreachable=0 failed=0`.
- [`health-check-2026-10-12.txt`](health-check-2026-10-12.txt) — independent SSH endpoint verification after the completed run.

The earlier authentication attempt was superseded by the successful completed run. Target addresses, passwords, and private keys are not committed.
