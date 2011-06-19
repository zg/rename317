@echo off
java -cp lib/PGLEngine2_Library.jar;bin -Djava.library.path=lib/native/windows;lib/native/macosx;lib/native/linux;lib/native/solaris rs2.SwingUI
pause