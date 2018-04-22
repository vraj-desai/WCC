param([Parameter(Mandatory = $true, position =0)]$source)

if(-not (Test-Path $source -ErrorAction SilentlyContinue)){
    Write-Error "Invalid path: $source"
    Exit-PSHostProcess
}

$ExcelApp = New-Object -com Excel.Application

$ExcelApp.Visible = $true
$WorkBook = $ExcelApp.workbooks.add()
$WorkSheet = $ExcelApp.worksheets.add()
$WorkSheet.Name = $source
$FileInfo = Get-ChildItem $source
$row = 1
foreach($file in $FileInfo){
    $WorkSheet.Cells.Item($row, 1) = $file.Name
    $WorkSheet.Cells.Item($row, 2) = $file.Length
    $row++
}
$range = "b1:b$($row -1)"
$WorkSheet.Cells.Item($row, 2) = "=SUM($range)"
[void]$WorkSheet.Columns("A:B").AutoFit()