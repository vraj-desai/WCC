param($ipaddress)
Write-Host ($ipaddress | nslookup $ipaddress | Select-String 'Name')