# Manual reliability evidence

From a control node with Ansible and a clean Linux target, invoke:

```powershell
./task-14/scripts/reliability-run.ps1 -TargetHost <host> -SshUser <user> -CurrentImage <registry/image:new-tag> -PreviousStableImage <registry/image:stable-tag>
```

Capture `first-apply.log`, `idempotency-apply.log`, `rollback.log`, and a real `health-check.txt`. The target IP, SSH credentials, and registry token must not be committed.
