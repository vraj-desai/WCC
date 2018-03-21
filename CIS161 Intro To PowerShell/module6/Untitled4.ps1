$n1 = 0
$n2 = 0
$file = 'file.txt'
foreach ( $l in (get-content $file) ) { 
   $n1++               
   $a = $l.split(" `n")      
   $n2 += $a.length    
}

Write-Host $n2