# Task 13 — Configuration Management Script

Ansible is used for configuration management. The playbook installs Docker prerequisites, creates the least-privileged app account/directories, writes non-secret environment configuration, enables Docker, pulls the selected image, starts the container, and verifies its health. It is designed to be idempotent.

## Deliverables checklist

- [x] Server prerequisite/configuration specification
- [x] Inventory, variables, Ansible playbook, required collection, and check script
- [x] Health-check task built into the playbook
- [ ] Ansible collection installation and first target-node execution log — pending-manual (Ansible and target host are unavailable)
