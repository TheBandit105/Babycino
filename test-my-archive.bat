@echo off
if "%1"=="" (
  echo Use this script to check your archive compiles correctly.
  echo Example: test-my-archive.bat my-babycino.zip
  exit /b
)
@echo on

echo Starting script.

@echo off
setlocal EnableExtensions

:tmploop
set "uniqdir=%tmp%\babycino~%RANDOM%.tmp"
if exist "%uniqdir%" goto :uniqLoop
@echo on

echo Creating %uniqdir%. Delete it yourself afterwards if you want.
mkdir %uniqdir%
echo Extracting archive %1 into %uniqdir%
contrib\infozip\unzip.exe %1 -d %uniqdir%
echo Moving into %uniqdir%\babycino.
cd %uniqdir%\babycino || echo Couldn't enter directory. Exiting. && exit /b
echo Executing test script.
test.bat
