param($proto)
NETSTAT -na | Select-String $proto | Out-GridView