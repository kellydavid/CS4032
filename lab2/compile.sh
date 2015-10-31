#!/bin/bash

# Create bin directory if it doesn't already exist
if [ ! -d "bin/" ]; then
        mkdir bin
fi

# Compile source files into bin directory
javac -d bin/ src/lab2/*.java
