param([Parameter(Mandatory=$true)][string]$Host, [Parameter(Mandatory=$true)][string]$User, [Parameter(Mandatory=$true)][string]$Image)
$env:MENTORSHIP_HOST = $Host
$env:MENTORSHIP_SSH_USER = $User
$env:APP_IMAGE = $Image
ansible-galaxy collection install -r task-13/ansible/requirements.yml
ansible-playbook -i task-13/ansible/inventory.ini task-13/ansible/site.yml --check --diff
