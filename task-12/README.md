# Task 12 — Jenkins-Docker Continuous Deployment

The supplied pipeline performs unit/browser quality gates, builds an image tagged with Jenkins build number plus Git SHA, optionally pushes it using Jenkins-managed Docker Hub credentials, replaces the running container, and waits for the application health endpoint.

## Configure

1. Use `task-12/Jenkinsfile` in a Pipeline job whose agent has Docker and access to the deployment port.
2. Add Docker Hub credentials with ID `dockerhub-credentials`.
3. Use the `DOCKERHUB_REPOSITORY` and `HOST_PORT` build parameters.
4. Run with `PUSH_IMAGE=true` only after credentials are present.

## Registry publication update

On 10 October 2026, the image was built from the repository root and published to Docker Hub as:

- `adrian255/alumni-mentorship:1-bd157e6` (immutable build tag)
- `adrian255/alumni-mentorship:latest`

The immutable manifest is available at digest `sha256:5b9f3450f007f1eafd66744e47189ec9e0fce741f700abe63ab2b5ed99e890d4`. This confirms registry publication only; it was performed from the local Docker Desktop host, not by a Jenkins job.

## Jenkins execution evidence

The Docker client was installed in the running Jenkins container and verified against its mounted Docker daemon (`evidence/jenkins-docker-client.txt`). This is a container-local change and must be repeated or baked into an agent image if Jenkins is recreated.

On 11 October 2026, Jenkins build **#12** completed successfully using `task-12/Jenkinsfile`. It ran 7 Maven tests (0 failures), built `adrian255/alumni-mentorship:12-47bbf33`, replaced the `alumni-mentorship` container on host port 8083, and passed the Docker health gate. The host-side endpoint returned `{"status":"UP"}`. See `evidence/jenkins-build-12-success.txt`.

`PUSH_IMAGE` remains disabled for this build because no Jenkins credential named `dockerhub-credentials` has been configured. The already-published immutable Docker Hub tag above remains the registry evidence; enabling a Jenkins-originated push requires the repository owner to create that credential with a Docker Hub access token.

## Deliverables checklist

- [x] Versioned Docker build/push/deploy pipeline
- [x] Registry credential integration isolated behind Jenkins credentials ID
- [x] Fresh-container replacement and health gate configured
- [x] Manual registry/CD evidence instructions
- [x] Docker Hub image published with immutable and `latest` tags
- [x] End-to-end Jenkins fresh-container deployment and health gate (build #12)
- [ ] Jenkins-originated Docker Hub push — requires the repository owner to add `dockerhub-credentials`
