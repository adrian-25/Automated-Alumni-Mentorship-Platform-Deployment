# Task 14 — Automated Provisioning and Reliability Validation

Task 14 provides a clean-target execution plan and a rollback playbook. Applying Task 13 twice demonstrates idempotency; the rollback playbook recreates the application from an explicit previously stable image and validates health before completing.

The reliability runner now generates its target inventory from the mandatory `TargetHost` and `SshUser` parameters. This replaces the former literal `${MENTORSHIP_HOST}` and `${MENTORSHIP_SSH_USER}` INI placeholders, which Ansible does not expand.

`SshPort` defaults to 22. Set it to 2222 for the documented VirtualBox NAT port-forwarding setup.

On Windows, `scripts/reliability-run-docker.ps1` runs the first apply, idempotency apply, and rollback through Docker Desktop. It uses `host.docker.internal:2222` by default, the local automation SSH key, and saves the three execution logs under `evidence/`. Use `-RollbackOnly` to retry only the rollback portion; its Docker API timeout is three minutes to allow the Java/Tomcat container to stop cleanly.

The true prior rollback image is `adrian255/alumni-mentorship:v1.0.0`, built from the immutable Git tag `v1.0.0` and published to Docker Hub on 2026-10-11. Use it as `PreviousStableImage`; do not use the current `1-bd157e6` tag for both values.

## Deliverables checklist

- [x] Clean-target provisioning, idempotency, health, and rollback procedure
- [x] Explicit Ansible rollback playbook and reusable reliability runner
- [x] Manual evidence requirements with no committed target secrets
- [x] First provisioning apply on the VirtualBox Ubuntu target, including Docker install, image pull, container start, and health `UP` ([`evidence/first-apply.log`](evidence/first-apply.log))
- [x] Rollback execution completed with a recreated container and passing health check ([`evidence/rollback.log`](evidence/rollback.log))
- [ ] Second apply with `changed=0` — still required to complete the idempotency evidence; the earlier attempt failed before authentication was corrected.
