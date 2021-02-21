echo Running the build script.
call build.bat
echo Compiling sample factorial program with babycino.
call babycino.bat progs\appel\Factorial.java factorial.c
echo Compiling resulting source with tcc.
call tcc.bat -o factorial.exe factorial.c
echo Running factorial program.
factorial.exe > fac10.txt
echo Checking the output is 3628800.
find "3628800" fac10.txt && (
  echo PASS: 10 factorial OK.
) || (
  echo FAIL: 10 factorial OK.
)

