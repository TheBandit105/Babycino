#!/bin/bash

# set -e makes the script exit automatically if any line fails.
set -e

echo "Running the build script."
./build.sh
echo "Compiling sample factorial program with babycino."
./babycino.sh progs/appel/Factorial.java factorial.c
echo "Compiling resulting source with cc."
cc -o factorial.o factorial.c
echo "Running factorial program."
./factorial.o > fac10.txt
echo "Checking the output is 3628800."
test `cat fac10.txt` -eq 3628800 || { echo "FAIL: 10 factorial OK."; exit; }
echo "PASS: 10 factorial OK."

