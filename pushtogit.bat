@echo off
git init
git add .
set /p NameOfCommit=What what you like to name your commit?
git commit -m "%NameOfCommit%"
git remote set-url --add --push origin https://github.com/JugieNoob/MCAST-Java-Booking-System.git
git pull
git push origin main --allow-unrelated-histories
echo "Committed to Github!"
echo "Press ENTER to close this window!"
set /p EnterToClose=