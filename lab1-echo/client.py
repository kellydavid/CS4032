from socket import socket
from urllib import quote

# Set up a new socket and connection to local server where the echo php script is served.
so = socket()
so.connect(("localhost", 8000))
# User enters message and HTTP request is formed.
message = raw_input("Message to send to server echo script:")
request = "GET /echo.php?message=" + quote(message) + " HTTP/1.1\r\n\r\n"
# Socket sends the request
print "Sent request: " + repr(request)
so.sendall(request)
# Received data doesn't all come in one packet so have to loop
print "Received:"
data = so.recv(1024)
while(True):
	print repr(data)
	data = so.recv(1024)
	if(not data):
		break
so.close()