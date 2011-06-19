@echo off
mkdir bin
javac -d ./bin -cp ./bin;./lib/PGLEngine2_Library.jar;lib ./src/extras/*.java ./src/rs2/*.java ./src/pgle/*.java
pause