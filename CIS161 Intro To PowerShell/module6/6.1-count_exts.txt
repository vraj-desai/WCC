param([string]$dir)
$xmlNum = 0
$dllNum = 0
$exeNum = 0
$otherNum = 0

foreach( $file in (Get-ChildItem $dir -Recurse)){
    if($file.Extension -eq '.xml'){
        $xmlNum++;
    }

    elseif($file.Extension -eq '.dll'){
        $dllNum++;
    }
    
    elseif($file.Extension -eq '.exe'){
        $exeNum++;
    }
    
    else{
        $otherNum++;
    }
}

Write-Host "In the directory $dir there are:`t 
                $dllNum dlls, $exeNum executables, $xmlNum xml files and $otherNum other file types"