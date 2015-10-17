package lab2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class Connection implements Runnable{

	Socket so;
	
	public Connection(Socket so){
		this.so = so;
	}
	
	@Override
	public void run() {
		//get string request
		try{
			// receive data
			String recvd = new BufferedReader(new InputStreamReader(so.getInputStream())).readLine();
			System.out.println("Received: \"" + recvd + "\\n\"");
			// send data
			so.getOutputStream().write(new String(recvd.toUpperCase() + "\n").getBytes());
			System.out.println("Sent: \"" + recvd.toUpperCase() + "\\n\"");
			// close socket
			so.close();
		}catch(Exception e){
			System.err.println("Error sending or receiving data.\n" + e.getMessage());
		}
	}
	
}
