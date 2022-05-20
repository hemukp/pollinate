$occupationdetails = get-content .\occupations.json | convertfrom-json
Write-Output "---------------- Query1 Output -----------------"
$occupationdetails | sort-object -Property Name | %{$_.name + "(" + $_.occupation[0] + ")"}
Write-Output "---------------- Query2 Output -----------------"
$occupationdetails.occupation | group | sort-object -property @{Expression="Count"}, @{Expression="Name"} | %{Write-Host "There are a total of"$_.Count (($_.Name).toLower()+"s").Trim()}