[CmdletBinding(SupportsPaging)]
param(
        [parameter(Mandatory)][string]$source,
        [parameter(Mandatory)][int]$tail
     )
if(-not (Test-Path $source)){
    throw "$source does not exist!"
}

$content = Get-Content $source
$numSkipLines = (($content.Length) - ($tail))
$lineCount = 0
ForEach($line in get-content $source)
{
    $lineCount++
    if($lineCount -gt ($numSkipLines+$PScmdlet.PagingParameters.Skip)){
        Write-Host $line
    }              
}