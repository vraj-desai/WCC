param($name, $value)
write-host 'add new environment variable ' -nonewline
write-host $name -nonewline
write-host ' with value ' -nonewline 
write-host $value
new-item -path env: -name $name -value $value 