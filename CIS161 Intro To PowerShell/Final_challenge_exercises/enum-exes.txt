param([Parameter(Mandatory = $true, position = 0)]$path)
if(-not(Test-Path $path)){
    Write-Error "Invalid path: $path"
    Exit-PSHostProcess
}

$files = Get-ChildItem $path | Where-Object{$_.Name -like "*.exe"}
$count = 0
$totalSize = 0
$largestSize = 0
$smallestSize = 0
$largestFilePath = $null
$smallestFilePath = $null
foreach($file in $files){
    $count++
    $totalSize += $file.Length
    if($file.Length -gt $largestSize){
        $largestSize = $file.Length
        $largestFilePath = $file.PSPath
    }
    if($file.Length -lt $smallestSize){
        $smallestSize = $file.Length
        $smallestFilePath = $file.PSPath
    }
}

Write-Host "There are $count exes in $path"
Write-Host "The total size of all exs is $totalSize"
Write-Host "The largest exe is $largestFilePath"
Write-Host "The smallest exe is $smallestFilePath"