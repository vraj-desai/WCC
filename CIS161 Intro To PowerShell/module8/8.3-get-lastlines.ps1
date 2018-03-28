[CmdletBinding(SupportsPaging)]
param(
        [parameter(Mandatory)][string]$source,
        [parameter(Mandatory)][int]$tail
     )
if(-not (Test-Path $source)){
    throw "$source does not exist!"
}

$numLines = (Get-Content $source|Measure-Object -Line).Lines
$numSkipLines = (($numLines) - ($tail))
$lineCount = 0
ForEach($line in get-content $source)
{
    $lineCount++
    if($lineCount -gt $numSkipLines){
        Write-Host $line
    }              
}