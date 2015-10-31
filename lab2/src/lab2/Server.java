package lab2;

import java.io.*;
import java.net.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Server {
	
	// constants
	public static final int THREAD_POOL_SIZE = 10;
	public static final String STUDENT_ID = "e19b9a3807b5cfaa4db33fd30468ef249bb86ccc16c08efbed08f3fb6959e346";
	
	// members
	private static ServerSocket ss;
	private static ThreadPoolExecutor connectionThreads;

	public static void main(String[] args) {
		// Check that args includes port number
		if(args.length != 2){
			System.out.println("Must use arguments <hostname> <portnumber>");
			System.exit(-1);
		}
		// Setup thread pool
		connectionThreads = new ThreadPoolExecutor(THREAD_POOL_SIZE, THREAD_POOL_SIZE, 1000, 
				TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
		listen(args[0], Integer.parseInt(args[1]));
	}
	
	public static void listen(String hostname, int portNumber){
		try {
			// Create server socket
			ss = new ServerSocket();
			ss.setReuseAddress(true);
			ss.bind(new InetSocketAddress(hostname, portNumber));
			while(true){
				// Setup a new Connection thread when a new client connects.
				connectionThreads.execute(new Connection(ss.accept()));
			}
		} catch (IOException e) {
			System.err.println("Error creating socket.\n" + e.getMessage());
			e.printStackTrace();
		}
		
	}
}
