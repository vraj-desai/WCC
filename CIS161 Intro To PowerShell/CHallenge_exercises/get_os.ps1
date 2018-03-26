param($ip)
Test-Connection $ip -Count 1 | Where-Object {$_.ResponseTimeTOLive -lt 65 -and $_.ResponseTimeTOLive -gt 128} | 
                                ForEach-Object {Write-Host 'The OS for' $ip 'is Windows'}