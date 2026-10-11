param(
  [Parameter(Mandatory=$true)][string]$Image,
  [string]$TargetHost = 'host.docker.internal',
  [string]$User = 'adrian',
  [int]$SshPort = 2222,
  [string]$ControllerKey = (Join-Path $env:USERPROFILE '.ssh\alumni_vm_automation')
)

$inventory = Join-Path ([System.IO.Path]::GetTempPath()) "alumni-mentorship-inventory-$PID.ini"
try {
  if (-not (Test-Path -LiteralPath $ControllerKey)) {
    throw "Controller SSH key not found: $ControllerKey"
  }
  @"
[mentorship]
target ansible_host=$TargetHost ansible_user=$User ansible_port=$SshPort ansible_ssh_private_key_file=/tmp/controller-key-secure
"@ | Set-Content -LiteralPath $inventory -NoNewline

  $workspace = (Get-Location).Path
  docker build -q -f task-13/Dockerfile.ansible-runner -t alumni-mentorship-ansible-runner:local .
  if ($LASTEXITCODE -ne 0) { throw 'Unable to build the Ansible controller image.' }
  docker run --rm -it `
    -v "${workspace}:/workspace" `
    -v "${inventory}:/tmp/inventory.ini:ro" `
    -v "${ControllerKey}:/tmp/controller-key:ro" `
    -w /workspace `
    -e "APP_IMAGE=$Image" `
    -e 'ANSIBLE_HOST_KEY_CHECKING=False' `
    alumni-mentorship-ansible-runner:local `
    sh -lc 'install -m 600 /tmp/controller-key /tmp/controller-key-secure && ansible-galaxy collection install -r task-13/ansible/requirements.yml && ansible-playbook -i /tmp/inventory.ini task-13/ansible/site.yml --check --diff --ask-become-pass'
}
finally {
  Remove-Item -LiteralPath $inventory -Force -ErrorAction SilentlyContinue
}
