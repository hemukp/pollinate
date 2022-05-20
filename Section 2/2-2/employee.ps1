$employees = get-content .\employee.json | convertfrom-json
$employees | ?{($_.months -lt 10) -and ($_.salary -gt 2000)} |sort-Object -Property $_.id | select-object name