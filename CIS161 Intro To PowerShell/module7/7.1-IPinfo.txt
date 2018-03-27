$hosts = '198.111.176.7','192.111.176.7','8.8.8.8','23.72.44.137', '198.111.176.8','12.0.1.28' 
function ipinfo([string] $ip){
    [regex] $temp = '\b(\d{1,3})\.(\d{1,3})\.(\d{1,3})\.(\d{1,3})\b'
    $matched = $ip -match $temp
    if(-not $matched){
        Write-Host "$ip is invalid IP adress!" -ForegroundColor red
        return
    }
    
    $valid = $true
    for($i = 1; $i -le 4; $i++){
        [int]$octet = $matches[$i]
        if($octet -lt 0 -or $octet -gt 255){
            $valid = $false
            break
        }
    }

    if(-not $valid){
        Write-Host "$ip is invalid IP adress!" -ForegroundColor Red
        return
    }
    
    $r = Test-Connection $ip -ErrorAction SilentlyContinue
    $status = $null
    $OSType = $null
    $Name = $null
    $ResponseTime = $null

    if($r.StatusCode -eq 0){
        $status = "dead" 
    } 
    else{
        $status = "alive"
    }

    $Name = (Resolve-DnsName $ip).NameHost
    if($Name -eq $null){
        $Name = "no name"
    }

    $ResponseTime = $r.ResponseTimeToLive

    if($ResponseTime -ge 1 -and $ReponseTime -le 64){
        $OS = "Linux"
    }
    elseif($ResponseTime -ge 65 -and $ReponseTime -le 128){
        $OS = "Windows"
    }
    else{
        $OS = "Unix"
    }

    #Write-Host "$ip `t $Name `t $status `t $OS" 
    "{0,-16} {1,-30} {2,-9} {3,-7}" -f $ip, $Name, $status, $OS
}

foreach($ipadress in $hosts){
    ipinfo($ipadress)
}