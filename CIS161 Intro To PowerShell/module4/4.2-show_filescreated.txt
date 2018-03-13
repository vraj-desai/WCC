param([datetime]$pastdate, $path)
$enddate = $pastdate.AddHours(24)
Get-ChildItem $path -file -recurse | 
    ? { $_.LastWriteTime -ge $pastdate -and $_.LastWriteTime -lt $enddate}