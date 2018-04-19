param([ValidateNotNullorEmpty()][String]$Target)
Get-WmiObject -Class win32_operatingsystem -ComputerName $Target | select CSName, PSComputerName, Caption, Manufacturer | Format-List
Get-WmiObject -Class win32_BIOS -ComputerName $Target | select Version, ReleaseDate | Format-List
WmiObject -Class Win32_LogicalDisk -ComputerName $Target | select DeviceId, Size | Format-List