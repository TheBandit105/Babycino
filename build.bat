@echo off
where /q java || echo Can't find java.exe. Add the JDK's bin directory to your path. && exit /b
where /q javac || echo Can't find javac.exe. Add the JDK's bin directory to your path. && exit /b
@echo on
call antlr4.bat -visitor -package babycino babycino\MiniJava.g4
javac -cp ".;contrib\antlr\antlr-4.9.1-complete.jar;%CLASSPATH%" babycino\*.java
