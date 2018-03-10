param($filename, $group, $control)
$d = New-Item test.txt -ItemType file
Write-Host 'The ACL for $filename before is: '
$d.GetAccessControl() | Select-Object -ExpandProperty access
$rule = New-Object System.Security.AccessControl.FileSystemAccessRule $group $control "allow"
$acl = Get-Acl $filename
$acl.AddAccessRule($rule)
Set-Acl -path $filename -AclObject $acl
Write-Host 'The ACL for $filename after is: '
$d.GetAccessControl() | Select-Object -ExpandProperty access
rm test.txt