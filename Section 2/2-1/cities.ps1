$cities = get-content ./cities.json | convertfrom-json
$cities | ?{$_.id -eq "1661"}