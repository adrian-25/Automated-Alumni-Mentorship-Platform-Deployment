# Registry and CD evidence to capture

Before enabling `PUSH_IMAGE`, create a Docker Hub access token and add it to Jenkins as Username with password credentials ID `dockerhub-credentials`. Set `DOCKERHUB_REPOSITORY` to `<your-dockerhub-user>/alumni-mentorship`.

Capture:

1. `registry-image.png` — Docker Hub tag/details page.
2. `commit-to-container.log` / `commit-to-container.png` — full successful Jenkins pipeline and deployment stages.
3. `deployed-health.txt` — actual health response from the agent host.

No registry credentials or unverified Docker Hub URL is committed.
