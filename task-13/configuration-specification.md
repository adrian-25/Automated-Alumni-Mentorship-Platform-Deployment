# Target-node configuration specification

| Category | Desired state |
|---|---|
| OS | Debian/Ubuntu-like Linux host with Python 3 and SSH access |
| Packages | `ca-certificates`, `curl`, `gnupg`, `docker.io` |
| User | System user `mentorship`, member of the `docker` group |
| Files | `/opt/alumni-mentorship` (0750), `/opt/alumni-mentorship/alumni-mentorship.env` (0640) |
| Service | Docker started and enabled |
| Port | Host port 8081 by default, mapped to container 8080 |
| Container | `alumni-mentorship`, image set through `APP_IMAGE`, restart policy `unless-stopped` |
| Health | `GET /alumni-mentorship/api/health` returns `{"status":"UP"}` |

No SSH passwords, private keys, registry tokens, or target addresses are committed. Provide host/user/image via environment variables or `run-check.ps1` parameters.
