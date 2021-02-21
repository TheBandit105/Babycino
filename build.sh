#!/bin/bash
./antlr4.sh -visitor -package babycino babycino/MiniJava.g4
javac -cp ".:./contrib/antlr/antlr-4.9.1-complete.jar:$CLASSPATH" babycino/*.java

