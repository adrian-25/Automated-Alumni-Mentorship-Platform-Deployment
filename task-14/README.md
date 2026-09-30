# Task 14 — Automated Provisioning and Reliability Validation

Task 14 provides a clean-target execution plan and a rollback playbook. Applying Task 13 twice demonstrates idempotency; the rollback playbook recreates the application from an explicit previously stable image and validates health before completing.

## Deliverables checklist

- [x] Clean-target provisioning, idempotency, health, and rollback procedure
- [x] Explicit Ansible rollback playbook and reusable reliability runner
- [x] Manual evidence requirements with no committed target secrets
- [ ] Provisioned target, idempotency, health, and rollback execution evidence — pending-manual (requires clean reachable Linux host and published registry images)
