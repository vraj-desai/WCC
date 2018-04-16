param([parameter(Mandatory)][string]$source = "localhost")
$numLines = 0
Write-Host $source
ForEach($line in get-content $source)
{
    $numLines++
    if($numLines -gt $PSCmdlet.PagingParameters.Skip){
        Write-Host $line
    }              
}