function joinfiles{
    if($args.Length -lt 3){
        Write-Host "[Less than 3 files in the input!]"
        exit
    }
    
    $filename = $args[$args.Length - 1]

    for($i; $i -lt ($args.length - 1); $i++){
        $currfileContent = Get-Content $args[$i] -Path .
        #Add-Content -Path $filename -Value $currfileContent
        Out-File -FilePath .\($filename) -Encoding ascii -InputObject $currfileContent
    }
}