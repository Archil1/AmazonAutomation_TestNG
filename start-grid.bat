@echo off
REM Batch file to start Selenium Grid using Docker Compose

REM Navigate to the directory containing docker-compose.yml
cd /d %~dp0

echo 🔄 Starting Selenium Grid using Docker Compose...
docker-compose up -d

echo ✅ Selenium Grid is starting in detached mode.
pause