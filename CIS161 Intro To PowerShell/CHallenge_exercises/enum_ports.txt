param($hostName)
22,80,443 | ForEach-Object {Test-NetConnection $hostName -Port $_} | Select-Object computerName, RemotePort, TcpTestSucceeded | format-table