@echo off
REM Stop and remove Selenium Grid containers

cd /d %~dp0
echo 🛑 Stopping Selenium Grid...
docker-compose down

echo ✅ Selenium Grid has been stopped.
pause