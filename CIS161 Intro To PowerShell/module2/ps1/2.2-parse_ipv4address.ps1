param($ipadress)
$octet1 = $ipadress.Substring(0,2)
$octet2 = $ipadress.Substring(4,6)
$octet3 = $ipadress.Substring(8,10)
$octet4 = $ipadress.Substring(12,14)

Write-Host('octet1:' + $octet1 + ' octet2:' + $octet2 + ' octet3:' + $octet3 + ' octet4:' + $octet4) 