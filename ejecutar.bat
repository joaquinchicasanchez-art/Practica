@echo off
chcp 65001 >nul
cd /d "%~dp0"
where java >nul 2>&1
if errorlevel 1 (
    echo No se encuentra Java. Instala el JDK 25 y vuelve a ejecutar este archivo.
    pause
    exit /b 1
)
java src\Main.java
pause
