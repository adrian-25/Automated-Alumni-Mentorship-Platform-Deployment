param(
  [Parameter(Mandatory=$true)][string]$TargetHost,
  [Parameter(Mandatory=$true)][string]$User,
  [Parameter(Mandatory=$true)][string]$Image,
  [int]$SshPort = 22
)
$inventory = Join-Path ([System.IO.Path]::GetTempPath()) "alumni-mentorship-inventory-$PID.ini"
$env:APP_IMAGE = $Image
try {
  @"
[mentorship]
target ansible_host=$TargetHost ansible_user=$User ansible_port=$SshPort
"@ | Set-Content -LiteralPath $inventory -NoNewline

  ansible-galaxy collection install -r task-13/ansible/requirements.yml
  ansible-playbook -i $inventory task-13/ansible/site.yml --check --diff
}
finally {
  Remove-Item -LiteralPath $inventory -Force -ErrorAction SilentlyContinue
}
