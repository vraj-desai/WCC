function ipinfo([string] $ip){
    if($ip -match [ipaddress]$ip){
        
    }
    else{
        Write-Host "[Invalid ip adress input!]"
    }
}