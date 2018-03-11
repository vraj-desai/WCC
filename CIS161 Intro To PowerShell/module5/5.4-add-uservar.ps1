param($name, $value)
[Environment]::SetEnvironmentVariable($name, $value)
writehost 'add new environment variable $name with value $value'