param([datetime]$starttime,[datetime]$endtime)
Get-EventLog System -EntryType Error -After $starttime -Before $endtime  
