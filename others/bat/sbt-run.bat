cd /d %~dp0
cd ../..
start sbt "run-main pl.gigiel.seldon.SeldonApp"
pause
