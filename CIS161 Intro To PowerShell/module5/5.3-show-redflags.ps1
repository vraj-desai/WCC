param($logname)
$count = 0
<<<<<<< HEAD
Get-EventLog $logname | Where-Object {$_.EntryType = error -or $_.EntryType = warning} | 
                        fm TimeGenerated,EntryType,Source,Message -autosize -wrap |
                        ForEach-Object {writehost $_ $count++}
write-host '$count total events found'
=======
Get-EventLog $logname | Where-Object {$_.EntryType = Error -or $_.EntryType = warning} | 
                        Format-table TimeGenerated,EntryType,Source,Message -autosize -wrap #|
                       # ForEach-Object {$_ $count++}
writehost '$count total events found'
>>>>>>> 377314a7dccd6e0c85fc64892b774c66d44cf587
