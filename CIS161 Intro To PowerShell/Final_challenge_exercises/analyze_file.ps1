param([Parameter(Mandatory = $true, position = 0)]$filePath)
if(-not(Test-Path $filePath)){
    Write-Error "Invalid Path: $filePath"
    Exit-PSHostProcess
}

$words = @{}
$content = Get-Content $filePath
foreach($line in $content){
    $lineWords = $line.split()
    foreach($word in $lineWords){
        if($words.Contains("$word")){
            $words.Item("$word")++
        }
        else{
            $words.add("$word",1)
        }
    }
}

$words.GetEnumerator() | Where-Object{$_.Value -gt 4}