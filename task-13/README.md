# Task 13 — Configuration Management Script

Ansible is used for configuration management. The playbook installs Docker prerequisites, creates the least-privileged app account/directories, writes non-secret environment configuration, enables Docker, pulls the selected image, starts the container, and verifies its health. It is designed to be idempotent.

## Target inventory

`inventory.ini` deliberately contains no committed host. Its previous `${MENTORSHIP_HOST}` and `${MENTORSHIP_SSH_USER}` values were literal INI values, not environment-variable interpolation, and would therefore fail to connect. `scripts/run-check.ps1` now creates a temporary inventory from its mandatory `TargetHost` and `User` arguments; the reliability runner uses the same approach. An operator can alternatively pass an owned inventory with a `mentorship` group.

For a VirtualBox NAT target with an SSH forwarding rule, use `-TargetHost 127.0.0.1 -SshPort 2222`. The runner writes `ansible_port` to its temporary inventory, so the same script works with either a normal Linux host on port 22 or the local VM.

On Windows, use `scripts/run-check-docker.ps1` instead of installing Ansible natively. It builds a small local Ansible controller image with `sshpass`, then connects to the VirtualBox NAT forward through `host.docker.internal:2222`. It uses the local automation key at `%USERPROFILE%\.ssh\alumni_vm_automation`, copying it to a protected path inside the controller container. It prompts only for the Ubuntu sudo password.

On a fresh target, Ansible check mode does not actually install `docker.io`. Docker-service, image, container, and health tasks are therefore deliberately skipped during `--check`; the subsequent non-check apply executes them.

## Deliverables checklist

- [x] Server prerequisite/configuration specification
- [x] Inventory, variables, Ansible playbook, required collection, and check script
- [x] Health-check task built into the playbook
- [x] Playbook/collection syntax validation completed in an Ansible container after the inventory correction (`evidence/ansible-syntax-check.log`)
- [x] VirtualBox Ubuntu target-node check and apply executed with the published immutable image. The check output reported `ok=5`, `changed=4`, `skipped=5`; the subsequent real apply is recorded in [`../task-14/evidence/first-apply.log`](../task-14/evidence/first-apply.log) and ends with application health `UP`.
