param ($rowCount)
if($rowCount -lt 0) {
    Write-Host "Please provide a rowCount value between 1 and 100 (both included) to view the output" -ForegroundColor Magenta 
}
if($rowCount -gt 100) {
    Write-Host "Tough to view the pattern for rowcounts greater than 100. Please provide a value between 1 and 100 (both included)" -ForegroundColor Magenta
    exit 0
}

for($a=0;$a -lt $rowCount; $a++){
    for($b=$rowCount-$a; $b -gt 0;$b--) {
        Write-host -NoNewLine "*"
    }
    Write-Host ""
 }