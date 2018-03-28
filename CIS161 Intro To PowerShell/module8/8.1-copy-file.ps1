[cmdletBinding(SupportsShouldProcess)]
param([parameter(Mandatory, Position = 0)][string]$source,
       [parameter(Mandatory, Position = 1)][string]$dest
      )

if(Test-Path $source){
    Copy-Item $source -Destination $dest -Recurse
}
else{
    throw "$source does not exist!"
}