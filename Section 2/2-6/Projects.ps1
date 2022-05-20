param ($numberOfProjectedMonths)
if($numberOfProjectedMonths -lt 0) {
    Write-Host "Please provide a the number of months value between 1 and 12 (both included) to view the output" -ForegroundColor Magenta 
    exit 0
}
if($numberOfProjectedMonths -gt 12) {
    Write-Host "Projections can only be made for a maximum of next 12 months. Please provide a value between 1 and 12 (both included)" -ForegroundColor Magenta
    exit 0
}
 $today = get-date
 $firstdayofthismonth = get-date $today -Day 1
 $projects=@()
 $id=1
 $eqp = 0
 $corelabor = 50
 $labor = 500
 for($a = 1; $a -le $numberOfProjectedMonths; $a++) {
    $laborrequired = $labor - (100*$a)
    if($laborrequired -lt $corelabor){$laborrequired = $corelabor}
    $projectobj=@(
        [pscustomobject]@{
            ID = $id
            ProjectedDate =  get-date $firstdayofthismonth.addMonths($a) -Format "yyyy-MM-dd"
            Equipment = $eqp + (50*$a)
            Labor = $laborrequired

        })
        $projects+=$projectobj
        $id++
 }
 $projects