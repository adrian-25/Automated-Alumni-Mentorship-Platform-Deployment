# Task 12 — Jenkins-Docker Continuous Deployment

The supplied pipeline performs unit/browser quality gates, builds an image tagged with Jenkins build number plus Git SHA, optionally pushes it using Jenkins-managed Docker Hub credentials, replaces the running container, and waits for the application health endpoint.

## Configure

1. Use `task-12/Jenkinsfile` in a Pipeline job whose agent has Docker and access to the deployment port.
2. Add Docker Hub credentials with ID `dockerhub-credentials`.
3. Set `DOCKERHUB_REPOSITORY` and optionally `HOST_PORT` in the job environment.
4. Run with `PUSH_IMAGE=true` only after credentials are present.

## Registry publication update

On 10 October 2026, the image was built from the repository root and published to Docker Hub as:

- `adrian255/alumni-mentorship:1-bd157e6` (immutable build tag)
- `adrian255/alumni-mentorship:latest`

The immutable manifest is available at digest `sha256:5b9f3450f007f1eafd66744e47189ec9e0fce741f700abe63ab2b5ed99e890d4`. This confirms registry publication only; it was performed from the local Docker Desktop host, not by a Jenkins job.

## Current Jenkins prerequisite

The Docker client was installed in the running Jenkins container and verified against its mounted Docker daemon (`evidence/jenkins-docker-client.txt`). This is a container-local change and must be repeated or baked into an agent image if Jenkins is recreated. Docker Hub publication is now available, but a Jenkins credential named `dockerhub-credentials` and an actual Jenkins CD build still need to be configured and captured.

## Deliverables checklist

- [x] Versioned Docker build/push/deploy pipeline
- [x] Registry credentials isolated in Jenkins credentials store
- [x] Fresh-container replacement and health gate configured
- [x] Manual registry/CD evidence instructions
- [x] Docker Hub image published with immutable and `latest` tags
- [ ] End-to-end Jenkins deployment — pending-manual (requires the Jenkins credential and a real pipeline build)
