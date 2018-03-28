[CmdletBinding(SupportsPaging)]
param([parameter(Mandatory)][string]$source)
if(-not (Test-Path $source)){
    throw "$source does not exist!"
}
$numLines = 0
ForEach($line in get-content $source)
{
    $numLines++
    if($numLines -gt $PSCmdlet.PagingParameters.Skip){
        Write-Host $line
    }              
}