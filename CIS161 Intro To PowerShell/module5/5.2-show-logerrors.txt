param([datetime]$starttime, [datetime]$endtime)
'System','Application' | ForEach-Object {Get-EventLog $_ -EntryType Error -After $starttime -Before $endtime}