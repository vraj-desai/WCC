param([datetime]$dpast)
$dtoday = Get-Date
$diff = $dtoday - $dpast
$diff