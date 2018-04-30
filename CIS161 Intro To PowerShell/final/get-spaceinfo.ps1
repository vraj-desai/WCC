$volumeInfo = Get-WmiObject win32_volume
$totalCapacity = 0
$totalFree = 0
[String]$drives = $null

foreach($volume in $volumeInfo){
    Write-Host $volume.DriveLetter
    $letter = $volume.DriveLetter
    $fileSystem = $volume.FileSystem
    if(($letter -ne $null) -and ($fileSystem -ne $null)){
        $drives = $drives + $letter
        $totalCapacity += $volume.Capacity
        $totalFree += $volume.FreeSpace
    }
}

$totalCapacity = ($totalCapacity/1gb)
$totalFree = ($totalFree/1gb)
Write-Host "Volumes:`t $drives"
Write-Host "Total Capacity(GB) `t $totalCapacity"
Write-Host "Total Free(GB) `t $totalFree"