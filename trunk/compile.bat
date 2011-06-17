mkdir bin
chdir bin
del *.class
chdir ..
javac -d ./bin -classpath ./bin ./src/rs2/*.java
javac -d ./bin -classpath ./bin ./src/pgle/*.java
pause