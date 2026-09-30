# Task 13 — Configuration Management Script

Ansible is used for configuration management. The playbook installs Docker prerequisites, creates the least-privileged app account/directories, writes non-secret environment configuration, enables Docker, pulls the selected image, starts the container, and verifies its health. It is designed to be idempotent.

## Deliverables checklist

- [x] Server prerequisite/configuration specification
- [x] Inventory, variables, Ansible playbook, required collection, and check script
- [x] Health-check task built into the playbook
- [x] Playbook/collection syntax validation completed in an Ansible container (`evidence/ansible-syntax-check.log`)
- [ ] First target-node `--check` and apply execution log — pending-manual (no reachable target host)
