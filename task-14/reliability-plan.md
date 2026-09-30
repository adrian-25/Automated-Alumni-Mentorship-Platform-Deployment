# Provisioning and reliability validation plan

1. Start with a clean Debian/Ubuntu target reachable over SSH, supplying target values only through environment variables/parameters.
2. Run Task 13's playbook to install prerequisites and deploy the selected immutable image.
3. Run the same playbook a second time. The recap should report zero changes for an unchanged target; save both logs.
4. Confirm `GET http://<target>:8081/alumni-mentorship/api/health` returns HTTP 200 and `status: UP`.
5. Run `task-14/ansible/rollback.yml` with a previous stable immutable image tag. It recreates the application container from that tag and verifies the same health endpoint.

The playbooks do not delete Docker images or volumes. The rollback is reversible by redeploying the newer immutable tag through Task 13.
