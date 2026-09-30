param(
  [Parameter(Mandatory=$true)][string]$TargetHost,
  [Parameter(Mandatory=$true)][string]$SshUser,
  [Parameter(Mandatory=$true)][string]$CurrentImage,
  [Parameter(Mandatory=$true)][string]$PreviousStableImage
)

$env:MENTORSHIP_HOST = $TargetHost
$env:MENTORSHIP_SSH_USER = $SshUser
$env:APP_IMAGE = $CurrentImage

ansible-galaxy collection install -r task-13/ansible/requirements.yml
ansible-playbook -i task-13/ansible/inventory.ini task-13/ansible/site.yml | Tee-Object task-14/evidence/first-apply.log
ansible-playbook -i task-13/ansible/inventory.ini task-13/ansible/site.yml | Tee-Object task-14/evidence/idempotency-apply.log
ansible-playbook -i task-13/ansible/inventory.ini task-14/ansible/rollback.yml -e "rollback_image=$PreviousStableImage" | Tee-Object task-14/evidence/rollback.log
