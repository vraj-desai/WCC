$numProcess = 0
$totCPUTime = 0
$maxCPUTime = 0
$minCPUTime = 0
$p = Get-Process | Where-Object { $_.TotalProcessorTime -gt 10}
foreach ($currProcess in $p){
    
    if($minCPUTime -eq 0){
        $minCPUTime = $currProcess.TotalProcessorTime.TotalSeconds
    }

    $numProcess++

    $totCPUTime += $currProcess.TotalProcessorTime.TotalSeconds

    if($currProcess.TotalProcessorTime.TotalSeconds -gt $maxCPUTime){
        $maxCPUTime = $currProcess.TotalProcessorTime.TotalSeconds
    }

    if($currProcess.TotalProcessorTime.TotalSeconds -lt $minCPUTime){
        $minCPUTime = $currProcess.TotalProcessorTime.TotalSeconds
    }
}

$avgCPUTime = ($totCPUTime/$numProcess)

Write-Host "$numProcess processes included in calculation"
write-host "$maxCPUTime is the maximum cpu time used by a process"
Write-Host "$minCPUTime is the minimum cpu time used by a process"
Write-Host "$avgCPUTime is the average cpu time used"