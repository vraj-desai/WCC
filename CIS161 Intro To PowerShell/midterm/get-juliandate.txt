param([datetime]$date)
$day = [string]($date.DayOfYear)
$year = [string]($date.Year)
$julianDate = $year + $day
Write-Host 'The Julian date is ' $julianDate