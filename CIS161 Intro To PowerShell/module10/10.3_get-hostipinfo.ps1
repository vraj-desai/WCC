#Note : I just added ping method to the custom object rather then useing test-netconnection in each methods

function get-hostinfo([String]$ipaddress){
    [regex] $temp = '\b(\d{1,3})\.(\d{1,3})\.(\d{1,3})\.(\d{1,3})\b'
    $matched = $ipaddress -match $temp
    if(-not $matched){
        Write-Host "$ipaddress is invalid IP adress!" -ForegroundColor red
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
        Write-Error "$ipaddress is invalid IP adress!" -ForegroundColor Red
        return
    }

    $IPObject = New-Object -TypeName psobject

    Add-Member -InputObject $IPObject -NotePropertyName Title -NotePropertyValue "Host Object"
    Add-Member -InputObject $IPObject -NotePropertyName IPAddress -NotePropertyValue "$ipaddress"
    Add-Member -InputObject $IPObject -MemberType ScriptMethod -Name ping `
        -value{
                  param([int]$count = 1)
                  $result = Test-NetConnection $this.IPAddress -ErrorAction SilentlyContinue
                  return $result
              }

    Add-Member -InputObject $IPObject -MemberType ScriptMethod -Name HostName `
        -Value{
                  $r = $this.ping()
                  return $r.PSComputerName
              }

    Add-Member -InputObject $IPObject -MemberType ScriptMethod -Name Status `
        -Value{
                $r = $this.ping()
                if($r.StatusCode -eq 0){
                    return "dead" 
                } 
                else{
                    return "alive"
                }
              } 
                
    Add-Member -InputObject $IPObject -MemberType ScriptMethod -Name Hops `
        -Value{
                $r = $this.ping()
                return $r.ReplySize
              }

    Add-Member -InputObject $IPObject -MemberType ScriptMethod -Name OS `
        -Value{
                $r = $this.ping()
                if($ResponseTime -ge 1 -and $ReponseTime -le 64){
                    return "Linux"
                }
                elseif($ResponseTime -ge 65 -and $ReponseTime -le 128){
                    return "Windows"
                }
                else{
                    return "Unix"
                }
              }

    return $IPObject
}