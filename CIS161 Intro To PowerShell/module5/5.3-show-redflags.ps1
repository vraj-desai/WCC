param($logname)
$count = 0
Get-EventLog $logname | Where-Object {$_.EntryType = Error -or $_.EntryType = warning} | 
                        Format-table TimeGenerated,EntryType,Source,Message -autosize -wrap #|
                       # ForEach-Object {$_ $count++}
writehost '$count total events found'