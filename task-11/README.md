# Task 11 - Docker Image and Container Lifecycle

`Dockerfile` is a multi-stage build: Maven compiles the WAR with Java 17, then Tomcat 10 serves it at `/alumni-mentorship`. The runtime exposes port 8080 and polls `/alumni-mentorship/api/health`.

## Reproduce

From the repository root:

```powershell
./task-11/scripts/container-lifecycle.ps1
```

It builds a versioned image, creates a container, maps host port 8081, checks health, reads logs, restarts, stops, and starts it. Remove it when finished with `docker rm -f alumni-mentorship-demo`.

## Deliverables checklist

- [x] Multi-stage Dockerfile and image-healthcheck configuration
- [x] Complete lifecycle script
- [x] Docker image built: `alumni-mentorship:v1.0.0` (details in `evidence/image-details.txt`)
- [x] Container ran on host port 8081 and returned `200 {"status":"UP"}` (see `evidence/health.txt`)
- [x] Create/log/inspect/restart/stop/start/remove lifecycle executed (see `evidence/` logs)
- [x] Browser screenshot of the running container - `evidence/running-container-browser.png` shows the dashboard served by `http://localhost:8081/alumni-mentorship/`
