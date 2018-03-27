$hosts = 'www.msnbc.com', '198.111.176.7', 'www.hut.fi', 'onedrive.microsoft.com'
$ntests = 10
$sleep = 5

function inet_stats($ntests_in, $sleep_in, $hosts_in){
    $stats_avg = @{}
    $stats_max = @{}
    $stats_overtimenum = @{}
    $hosts_in | foreach {   
            $stats_avg[$_] = 0 
            $stats_max[$_] = 0 
            $stats_overtimenum[$_] = 0
        } 

    for($i = 1; $i -le $ntests_in; $i++){
        if($i -eq $ntests_in){ Write-Host "$ntests_in tests" }
        foreach($h in $hosts_in) {
            $r = test-connection $h -count 1 -ErrorAction SilentlyContinue
            $stats_avg[$h] +=  $r.ResponseTime
            if( $r.ResponseTime -gt $stats_max[$h]){   
                $stats_max[$h] = $r.ResponseTime
            }
            if( $r.ResponseTime -gt 500){
                $stats_overtimenum[$h]++
            }
       }
       start-sleep -Seconds $sleep_in
    }

    for($i = 0; $i -lt ($hosts_in.length); $i++){   
        $avgresponsetime = $stats_avg[$hosts[$i]] / $ntests_in
        write-host "$($hosts_in[$i]) $avgresponsetime $($stats_max[$hosts_in[$i]]) $($stats_overtimenum[$hosts_in[$i]])"
    }  
}

inet_stats $ntests $sleep $hosts