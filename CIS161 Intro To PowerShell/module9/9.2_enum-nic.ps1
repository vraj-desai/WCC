param([ValidateNotNullorEmpty()][Parameter(Mandatory=$false, Position=0)]$Target = "localhost")
$nics = Get-WmiObject -Class Win32_NetworkAdapterConfiguration -ComputerName $Target
foreach($nic in $nics){
    if(-not ($nic.IPAddress -eq $null)){ #This condition is breaking somehow
        Write-Host $nic.Description `t $nic.IPAddress[0] `t $nic.MACAddress 
    }
}