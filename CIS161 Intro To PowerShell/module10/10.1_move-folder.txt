param(
    [Parameter(Mandatory = $true, position = 0)]$Source,
    [Parameter(Mandatory = $true, position = 1)]$Target
)

if(-not (Test-Path $Source -ErrorAction SilentlyContinue)){
    Write-Error "Invalid source path: $Source"
    Exit-PSHostProcess 
}
 
if(-not (Test-Path $Target -ErrorAction SilentlyContinue)){
    Write-Error "Invalid target path: $Source"
    Exit-PSHostProcess 
}

$WSShell = New-Object -com shell.application
$src = $WSShell.NameSpace($Source)
$tar = $WSShell.NameSpace($Target)
$fileCount = 0
foreach($file in $src.Items()){
    $name = $file.Name
    Write-Host "$source\$Name" 
    $tar.MoveHere($file)
    $fileCount++
}
Write-Host "$fileCount files moved to $Target"