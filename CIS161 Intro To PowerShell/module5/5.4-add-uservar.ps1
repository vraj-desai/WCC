param($name, $value)
new-item -path env: -name $name -value $value
writehost 'add new environment variable' -nonewline
writehost $name -nonewline
writehost 'with value' -nonewline 
writehost $value