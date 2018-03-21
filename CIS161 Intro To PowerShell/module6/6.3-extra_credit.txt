#basically just added two process and two process name variables updated them to hold the relevent process and their time
 
$numProcess = 0
$totCPUTime = 0
$maxCPUTime = 0
$minCPUTime = 0
$minCPUTimeProcess = $null
$maxCPUTimeProcess = $null
$minCPUTimeProcessName = $null
$maxCPUTimeProcessName = $null

$p = Get-Process | Where-Object { $_.TotalProcessorTime -gt 10}

foreach ($currProcess in $p){
    
    if($minCPUTime -eq 0){
        $minCPUTime = $currProcess.TotalProcessorTime.TotalSeconds
        $minCPUTimeProcess = $currProcess
    }

    $numProcess++

    $totCPUTime += $currProcess.TotalProcessorTime.TotalSeconds

    if($currProcess.TotalProcessorTime.TotalSeconds -gt $maxCPUTime){
        $maxCPUTime = $currProcess.TotalProcessorTime.TotalSeconds
        $maxCPUTimeProcess = $currProcess
    }

    if($currProcess.TotalProcessorTime.TotalSeconds -lt $minCPUTime){
        $minCPUTime = $currProcess.TotalProcessorTime.TotalSeconds
        $minCPUTimeProcess = $currProcess
    }
}

$avgCPUTime = ($totCPUTime/$numProcess)
$minCPUTimeProcessName = ($minCPUTimeProcess.Name)
$maxCPUTimeProcessName = ($maxCPUTimeProcess.Name)

Write-Host "$numProcess processes included in calculation"
write-host "$maxCPUTime is the maximum cpu time used by a process $minCPUTimeProcessName"
Write-Host "$minCPUTime is the minimum cpu time used by a process $maxCPUTimeProcessName"
Write-Host "$avgCPUTime is the average cpu time used"