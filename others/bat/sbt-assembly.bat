cd /d %~dp0
cd ../..
start sbt assembly
echo java -jar something.jar [class.with.main.function]
pause
