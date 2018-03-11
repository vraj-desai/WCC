param($logname)
$count = 0
Get-EventLog $logname | Where-Object {$_.EntryType = error -or $_.EntryType = warning} | 
                        fm TimeGenerated,EntryType,Source,Message -autosize -wrap |
                        ForEach-Object {writehost $_ $count++}
writehost '$count total events found'