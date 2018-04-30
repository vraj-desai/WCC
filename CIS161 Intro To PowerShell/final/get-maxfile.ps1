param([Parameter(Mandatory = $true, position = 0)]$path)

if(-not(test-path $path)){
    Write-Host "Invalid path!" -ForegroundColor Red
    exit
}

$dirCheck = (Get-Item $path).PSIsContainer

if(-not$dirCheck){
    Write-Host "$path is not directory!" -ForegroundColor Red
    exit
}

$numFiles = 0
$largestFileSize = 0
$largestFileName = $null
$pathInfo = Get-ChildItem $path -Recurse

foreach($file in $pathInfo){
    $numFiles++
    if($file.Length -gt $largestFileSize){
        $largestFileName = $file.Name
        $largestFileSize = $file.length
    }
}

Write-Host "There are $numFiles files in $path"
Write-Host "Largest file is $largestFileName with a size of $largestFileSize"