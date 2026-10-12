# Limitations and future enhancements

## Current MVP limitations

- H2 is in-memory and unsuitable for production persistence.
- The role selector demonstrates authorization workflow but is not an authentication/authorization system.
- No notification, scheduling, calendar, messaging, or matching engine exists.
- Jenkins, Docker Hub, Tomcat host, and Ansible target environments are configured externally; their final run evidence depends on the retained local lab configuration.
- Selenium tests use deterministic seeded browser data and do not provide cross-browser or load testing coverage.
- Docker Hub registry tags `1-bd157e6` and `v1.0.0`, target-node provisioning, idempotency, and rollback were verified on the local VirtualBox Ubuntu target. This is a single-node lab validation, not a high-availability production deployment.
- The Docker CLI and socket access added to the current Jenkins container are runtime configuration, not an immutable Jenkins image definition; rebuilding that container requires repeating the setup or baking it into a custom agent image.

## Recommended next steps

1. Add Spring Security with university SSO/OIDC and server-side authorization tied to identities.
2. Move persistence to PostgreSQL with backups, migrations, and encrypted configuration.
3. Add email/calendar workflows and an auditable admin action history.
4. Publish immutable signed images and deploy through a private registry with vulnerability scanning.
5. Add GitHub webhook-triggered Jenkins CI, deployment environments, metrics, centralized logs, alerting, and backups.
6. Extend test coverage with accessibility, API contract, concurrency, and browser-matrix testing.
