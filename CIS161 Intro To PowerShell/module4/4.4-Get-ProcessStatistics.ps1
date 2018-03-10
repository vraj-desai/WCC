$p = get-process
write-host "1) The number of processes running is " -nonewline
$P | foreach-object -begin{ $cnt = 0} -process { $cnt++}  -end { write-host $cnt -foreground Magenta}
write-host "2) The number of processes running is " -nonewline 
$pcnt = $p | measure-object
write-host $pcnt.Count -ForegroundColor Magenta
$totalws = 0
$p | foreach-object { $totalws += $_.PeakWorkingset64}
write-host "Total working set is $totalws`n" 
#$p | Sort-Object $ |Select-Object name, @{Name = "PWS(MB)"; Expression = $_.VirtualMemorySize64} | Select-Object -first 3
$p | Sort-Object PeakWorkingSet64 -Descending | Select-Object name, @{Name = "PWS(MB)"; Expression = {$_.WorkingSet64}} | Select-Object -first 3