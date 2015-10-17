lab2 Multithreaded Server
=========================

Student: David Kelly
Student ID: e19b9a3807b5cfaa4db33fd30468ef249bb86ccc16c08efbed08f3fb6959e346

The code for the server is written in java. There is an example client written in python which can send messages to the server. The server uses the Java ThreadPoolExecutor to process multiple simultaneous connections in separate threads.

## Dependencies for Server Code
+ Java

## To Compile Server
Run the compile.sh script like so

	./compile.sh

## To Run Server
Run the start.sh script and pass the port number to listen on as a parameter.

	./start.sh <port-number>

## Using the sample client.py
To send a message to the server execute the client.py script like this

	python client.py <address-of-server> <port-number-of-server> <message>