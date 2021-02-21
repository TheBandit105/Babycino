#!/bin/bash
exec java -cp ".:./contrib/antlr/antlr-4.9.1-complete.jar:$CLASSPATH" babycino.Babycino "$@"

