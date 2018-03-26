param($pathName)
$count = 0
Get-ChildItem $pathName -Recurse | where-object {$_.Name -ilike 'a*' -or $_.Name -ilike 'b*' -or $_.Name -ilike 'c*'} | ForEach-Object {$count++}
Write-Host 'There are ' $count 'files whose name begins with a, b or c'