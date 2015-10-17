from socket import socket, AF_INET, SOCK_STREAM
import sys

def sendRequest(host, port, request):
	# Initialise Socket
	so = socket(AF_INET, SOCK_STREAM)
	try:
		# connect to server
		so.connect((host, port))
		# Send request
		so.sendall(request)
		return so.recv(1024)
	finally:
		so.close()

if __name__ == '__main__':
	if(len(sys.argv) is not 4):
		raise Exception("Must supply hostname, port number and request to send.")

	received = sendRequest(sys.argv[1], int(sys.argv[2]), sys.argv[3])
	print "Sent: " + sys.argv[3] + "\n"
	print "Received: " + received 