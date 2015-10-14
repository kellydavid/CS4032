from socket import socket, AF_INET, SOCK_STREAM
import sys

HOST, PORT = "localhost", 8000

def sendRequest(request):
	# Initialise Socket
	so = socket(AF_INET, SOCK_STREAM)
	try:
		# connect to server
		so.connect((HOST, PORT))
		# Send request
		so.sendall(request)
		return so.recv(1024)
	finally:
		so.close()

if __name__ == '__main__':
	if(len(sys.argv) is not 2):
		raise Exception("Must provide the request to send.")

	received = sendRequest(sys.argv[1])
	print "Sent: " + sys.argv[1] + "\n"
	print "Received: " + received 