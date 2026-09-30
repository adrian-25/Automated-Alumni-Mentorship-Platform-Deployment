# Manual execution evidence

Install Ansible on the control node, set a real `MENTORSHIP_HOST`, `MENTORSHIP_SSH_USER`, and published `APP_IMAGE`, then run:

```powershell
./task-13/scripts/run-check.ps1 -Host <host> -User <ssh-user> -Image <registry/image:tag>
```

Save the first `--check --diff` output in `first-check.log`, then a normal apply in `first-apply.log`. The remote host and credentials must remain outside Git.
