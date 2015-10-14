from SocketServer import TCPServer, BaseRequestHandler
import sys

default_hostname = 'localhost'

class ConnectionHandler(BaseRequestHandler):
	""" Connection Handler
		Handles connections
	"""
	def handle(self):
		self.data = self.request.recv(1024).strip()
		#print "{} wrote:".format(self.client_address[0])
		print self.data
		# just send back the same data, but upper-cased
		self.request.sendall(self.data.upper())

if __name__ == '__main__':
	if(len(sys.argv) is not 2):
		raise Exception("Must provide the port number to listen on")
	else:
		server = TCPServer((default_hostname, int(sys.argv[1])), ConnectionHandler)
		server.serve_forever()
