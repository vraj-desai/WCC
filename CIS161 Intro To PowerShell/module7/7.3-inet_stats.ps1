clear-host
$hosts = 'www.msnbc.com', '198.111.176.7', 'www.hut.fi', 'onedrive.microsoft.com'
$ntests = 3000
$cnt = 0 
$stats_avg = @{}
$stats_max = @{}
$hosts | foreach {   
            $stats_avg[$_] = 0 
            $stats_max[$_] = 0 
        } 
for($i =0; $i -lt $ntests; $i ++){   
       $cnt++  
       if(($cnt % 500) -eq  0){ write-host "$cnt tests" } 
       foreach($h in $hosts) { 
            $r = test-connection $h -count 1 -ErrorAction SilentlyContinue
            $stats_avg[$h] +=  $r.ResponseTime
            if( $r.ResponseTime -gt $stats_max[$h]){   
                $stats_max[$h] = $r.ResponseTime
            }   
       }
       start-sleep -Seconds 10  
} 
 
for($i = 0; $i -lt ($hosts.length); $i++){   
     $avgresponsetime = $stats_avg[$hosts[$i]] / $ntests
     write-host "$($hosts[$i]) $avgresponsetime $($stats_max[$hosts[$i]])"
}   