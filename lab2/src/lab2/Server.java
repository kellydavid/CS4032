package lab2;

import java.io.*;
import java.net.*;
//import java.util.concurrent.ThreadPoolExecutor;

public class Server {
	
	// constants
	public static final int THREAD_POOL_SIZE = 10;
	
	// members
	private static ServerSocket ss;
	private static int portNumber;
	//private static ThreadPoolExecutor connectionThreads;

	public static void main(String[] args) {
		// Check that args includes port number
		if(args.length != 1){
			System.out.println("Must supply the port number as an argument");
		}else{
			portNumber = Integer.parseInt(args[0]);
			listen();
		}
		
	}
	
	public static void listen(){
		try {
			ss = new ServerSocket();
			ss.setReuseAddress(true);
			ss.bind(new InetSocketAddress(InetAddress.getLocalHost(), portNumber));
			while(true){
				Socket so = ss.accept();
				// receive data
				String recvd = new BufferedReader(new InputStreamReader(so.getInputStream())).readLine();
				System.out.println("Received: \"" + recvd + "\\n\"");
				// send data
				so.getOutputStream().write(new String(recvd.toUpperCase() + "\n").getBytes());
				System.out.println("Sent: \"" + recvd.toUpperCase() + "\\n\"");
				// close socket
				so.close();
			}
			//ss.close();
		} catch (IOException e) {
			System.err.println("Error creating socket.\n" + e.getMessage());
			try {
				if(ss != null)
					ss.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}

}
