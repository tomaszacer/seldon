cd /d %~dp0
cd ../..
start sbt "export runtime:fullClasspath"
pause
