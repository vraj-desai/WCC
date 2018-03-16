param($subnet) 
1..10 | ForEach-Object {Test-NetConnection ($subnet + [string]$_)} | select-object computerName,pingSucceeded | Format-Table