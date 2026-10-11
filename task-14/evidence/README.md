# Reliability evidence

Live VirtualBox Ubuntu-target evidence is captured here:

- [`first-apply.log`](first-apply.log) — Docker provisioning, container start, and application health `UP`.
- [`rollback.log`](rollback.log) — image pull, container recreation, and a successful post-rollback health check.
- [`health-check-2026-10-11.txt`](health-check-2026-10-11.txt) — independent SSH and endpoint verification after rollback.

`idempotency-apply.log` records the earlier failed authentication attempt. A later second apply with `changed=0` is still needed for a complete idempotency demonstration. Target addresses, passwords, and private keys are not committed.
