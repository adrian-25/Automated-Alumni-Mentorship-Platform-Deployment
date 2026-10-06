# Viva preparation

1. **Why use a WAR with Spring Boot?** It permits deployment to an external Tomcat target while retaining Spring Boot's local embedded-server workflow.
2. **Why is the request transition service important?** It centralizes state/role validation so the controller/UI cannot accidentally bypass workflow rules.
3. **What stops deployment when tests fail?** Maven returns a non-zero exit code; Jenkins marks the stage failed and never executes later stages.
4. **Why tag images with build number and SHA?** Tags identify the exact source/build and make rollback deterministic.
5. **What makes an Ansible playbook idempotent?** Declarative `state` values let a second run report no change when the machine already matches desired state.
6. **How does rollback work here?** The rollback playbook explicitly recreates the container from a previously stable immutable image tag and validates health.
7. **Why use Jenkins credentials?** Secrets stay out of Git and are injected only for the stage needing them.
8. **What is deliberately excluded from the MVP?** SSO, managed persistence, notifications, calendar scheduling, and production observability.
9. **Why did the first Task 10 Jenkins build fail before testing?** Its branch specifier was a raw commit SHA. Jenkins Git SCM requested it as a remote branch ref, which does not exist. Immutable evidence branches fixed checkout without moving a tag or branch.
10. **How was the Ansible inventory bug fixed?** Shell-looking `${...}` text in an INI file is literal to Ansible. The checked-in inventory is target-free, and the PowerShell runners generate a temporary inventory from explicit mandatory host and SSH-user parameters.
