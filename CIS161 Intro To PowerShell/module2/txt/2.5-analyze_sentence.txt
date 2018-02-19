param($sentence)
write-host ('The sentence passed is ') -nonewline
Write-Host $sentence -ForegroundColor Magenta
$words = $sentence.split()
write-host ('There are ' + $words.length + ' words in sentence')
Write-Host ('The first word is ') -NoNewline
Write-Host $words[0] -ForegroundColor Magenta
Write-Host ('The last word is ') -NoNewline
Write-Host $words[[int]($words.length - 1)] -ForegroundColor Magenta
Write-Host ('The first three words in the sentence are ') -NoNewline
Write-Host $words[0..2] -ForegroundColor Magenta
Write-Host ('The last three words in the sentence are ') -NoNewline
Write-Host $words[[int]($words.length - 3)..[int]($words.length - 1)] -ForegroundColor Magenta