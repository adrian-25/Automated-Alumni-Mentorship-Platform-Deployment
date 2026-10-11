param(
  [Parameter(Mandatory=$true)][string]$CurrentImage,
  [Parameter(Mandatory=$true)][string]$PreviousStableImage,
  [string]$TargetHost = 'host.docker.internal',
  [string]$SshUser = 'adrian',
  [int]$SshPort = 2222,
  [string]$ControllerKey = (Join-Path $env:USERPROFILE '.ssh\alumni_vm_automation'),
  [switch]$RollbackOnly
)

$inventory = Join-Path ([System.IO.Path]::GetTempPath()) "alumni-mentorship-inventory-$PID.ini"
try {
  if (-not (Test-Path -LiteralPath $ControllerKey)) {
    throw "Controller SSH key not found: $ControllerKey"
  }
  @"
[mentorship]
target ansible_host=$TargetHost ansible_user=$SshUser ansible_port=$SshPort ansible_ssh_private_key_file=/tmp/controller-key-secure
"@ | Set-Content -LiteralPath $inventory -NoNewline

  $workspace = (Get-Location).Path
  docker build -q -f task-13/Dockerfile.ansible-runner -t alumni-mentorship-ansible-runner:local .
  if ($LASTEXITCODE -ne 0) { throw 'Unable to build the Ansible controller image.' }
  $run = {
    param([string]$Playbook, [string[]]$ExtraArgs, [string]$LogFile)
    docker run --rm -it `
      -v "${workspace}:/workspace" `
      -v "${inventory}:/tmp/inventory.ini:ro" `
      -v "${ControllerKey}:/tmp/controller-key:ro" `
      -w /workspace `
      -e "APP_IMAGE=$CurrentImage" `
      -e 'ANSIBLE_HOST_KEY_CHECKING=False' `
      alumni-mentorship-ansible-runner:local `
      sh -lc "install -m 600 /tmp/controller-key /tmp/controller-key-secure && ansible-galaxy collection install -r task-13/ansible/requirements.yml && ansible-playbook -i /tmp/inventory.ini $Playbook $($ExtraArgs -join ' ') --ask-become-pass" |
      Tee-Object -FilePath $LogFile
    if ($LASTEXITCODE -ne 0) { throw "Ansible playbook failed: $Playbook" }
  }

  if (-not $RollbackOnly) {
    & $run 'task-13/ansible/site.yml' @() 'task-14/evidence/first-apply.log'
    & $run 'task-13/ansible/site.yml' @() 'task-14/evidence/idempotency-apply.log'
  }
  & $run 'task-14/ansible/rollback.yml' @("-e rollback_image=$PreviousStableImage") 'task-14/evidence/rollback.log'
}
finally {
  Remove-Item -LiteralPath $inventory -Force -ErrorAction SilentlyContinue
}
