param(
  [Parameter(Mandatory=$true)][string]$TargetHost,
  [Parameter(Mandatory=$true)][string]$SshUser,
  [Parameter(Mandatory=$true)][string]$CurrentImage,
  [Parameter(Mandatory=$true)][string]$PreviousStableImage
)

$inventory = Join-Path ([System.IO.Path]::GetTempPath()) "alumni-mentorship-inventory-$PID.ini"
$env:APP_IMAGE = $CurrentImage

try {
  @"
[mentorship]
target ansible_host=$TargetHost ansible_user=$SshUser
"@ | Set-Content -LiteralPath $inventory -NoNewline

  ansible-galaxy collection install -r task-13/ansible/requirements.yml
  ansible-playbook -i $inventory task-13/ansible/site.yml | Tee-Object task-14/evidence/first-apply.log
  ansible-playbook -i $inventory task-13/ansible/site.yml | Tee-Object task-14/evidence/idempotency-apply.log
  ansible-playbook -i $inventory task-14/ansible/rollback.yml -e "rollback_image=$PreviousStableImage" | Tee-Object task-14/evidence/rollback.log
}
finally {
  Remove-Item -LiteralPath $inventory -Force -ErrorAction SilentlyContinue
}
