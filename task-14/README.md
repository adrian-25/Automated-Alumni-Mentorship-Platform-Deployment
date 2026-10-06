# Task 14 — Automated Provisioning and Reliability Validation

Task 14 provides a clean-target execution plan and a rollback playbook. Applying Task 13 twice demonstrates idempotency; the rollback playbook recreates the application from an explicit previously stable image and validates health before completing.

The reliability runner now generates its target inventory from the mandatory `TargetHost` and `SshUser` parameters. This replaces the former literal `${MENTORSHIP_HOST}` and `${MENTORSHIP_SSH_USER}` INI placeholders, which Ansible does not expand.

## Deliverables checklist

- [x] Clean-target provisioning, idempotency, health, and rollback procedure
- [x] Explicit Ansible rollback playbook and reusable reliability runner
- [x] Manual evidence requirements with no committed target secrets
- [ ] Provisioned target, idempotency, health, and rollback execution evidence — pending-manual (requires clean reachable Linux host and published registry images)
