# Task 13 — Configuration Management Script

Ansible is used for configuration management. The playbook installs Docker prerequisites, creates the least-privileged app account/directories, writes non-secret environment configuration, enables Docker, pulls the selected image, starts the container, and verifies its health. It is designed to be idempotent.

## Target inventory

`inventory.ini` deliberately contains no committed host. Its previous `${MENTORSHIP_HOST}` and `${MENTORSHIP_SSH_USER}` values were literal INI values, not environment-variable interpolation, and would therefore fail to connect. `scripts/run-check.ps1` now creates a temporary inventory from its mandatory `Host` and `User` arguments; the reliability runner uses the same approach. An operator can alternatively pass an owned inventory with a `mentorship` group.

## Deliverables checklist

- [x] Server prerequisite/configuration specification
- [x] Inventory, variables, Ansible playbook, required collection, and check script
- [x] Health-check task built into the playbook
- [x] Playbook/collection syntax validation completed in an Ansible container after the inventory correction (`evidence/ansible-syntax-check.log`)
- [ ] First target-node `--check` and apply execution log — pending-manual (no reachable target host)
