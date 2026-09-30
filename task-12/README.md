# Task 12 — Jenkins-Docker Continuous Deployment

The supplied pipeline performs unit/browser quality gates, builds an image tagged with Jenkins build number plus Git SHA, optionally pushes it using Jenkins-managed Docker Hub credentials, replaces the running container, and waits for the application health endpoint.

## Configure

1. Use `task-12/Jenkinsfile` in a Pipeline job whose agent has Docker and access to the deployment port.
2. Add Docker Hub credentials with ID `dockerhub-credentials`.
3. Set `DOCKERHUB_REPOSITORY` and optionally `HOST_PORT` in the job environment.
4. Run with `PUSH_IMAGE=true` only after credentials are present.

## Deliverables checklist

- [x] Versioned Docker build/push/deploy pipeline
- [x] Registry credentials isolated in Jenkins credentials store
- [x] Fresh-container replacement and health gate configured
- [x] Manual registry/CD evidence instructions
- [ ] Registry publication and end-to-end Jenkins deployment — pending-manual (requires Docker Hub credentials and Jenkins agent)
