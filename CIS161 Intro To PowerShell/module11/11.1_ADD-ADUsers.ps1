$users = Import-Csv .\AD-Users.csv
$suffixNum = 00
foreach($user in $users){
    $ou = "ou=" + $suffixNum + "-MCOffice"
    $dc2 = $user.LDAP2
    $dc1 = $user.LDAP1
    $adpath = "$ou,$dc2,$dc1"
}