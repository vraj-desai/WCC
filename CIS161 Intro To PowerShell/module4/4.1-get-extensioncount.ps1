param($parent, $child)
$dir = $parent + '\' + $child
Write-Host 'The path analyzed is: ' -NoNewline
Write-Host $dir
$files = Get-ChildItem $dir -File
$files | Sort-Object Extension | Group-Object Extension -NoElement
$info = $files | Measure-Object -Property Length -sum
Write-Host 'The number of files is ' -NoNewline
Write-Host $info.Count
Write-Host 'The size of all files is ' -NoNewline
Write-Host $info.Sum