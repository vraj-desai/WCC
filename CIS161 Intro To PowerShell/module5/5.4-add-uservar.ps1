param($name, $value)
<<<<<<< HEAD
new-item -path env: -name $name -value $value
write-host 'add new environment variable' -nonewline
write-host $name -nonewline
write-host 'with value' -nonewline 
write-host $value
=======
write-host 'add new environment variable ' -nonewline
write-host $name -nonewline
write-host ' with value ' -nonewline 
write-host $value
new-item -path env: -name $name -value $value 
>>>>>>> 377314a7dccd6e0c85fc64892b774c66d44cf587
