package lab2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class Connection implements Runnable{

	private Socket so;
	private String recvd;
	
	public Connection(Socket so){
		this.so = so;
	}
	
	@Override
	public void run() {
		//get string request
		try{
			// receive data
			recvd = new BufferedReader(new InputStreamReader(so.getInputStream())).readLine();
			System.out.println("Received: \"" + recvd + "\" from " + so.getInetAddress() + ":" + so.getPort());
			// process request
			String result = process(recvd);
			if(result != null){
				// send data
				so.getOutputStream().write(result.getBytes());
				System.out.println("Sent: \"" + result + "\"");
			}
			// close socket
			so.close();
		}catch(Exception e){
			System.err.println("Error sending or receiving data.\n" + e.getMessage());
		}
	}
	
	
	/**
	 * Takes the request received as a String. It returns the String to be sent back to the client.
	 * 
	 * @param request
	 * @return
	 */
	private String process(String request){
		if(request.equals("HELO text")){
			return "HELO text\nIP:[" + so.getLocalAddress().getHostAddress() + 
					"]\nPort:[" + so.getLocalPort() + "]\nStudentID:[" + Server.STUDENT_ID + "]\n";
		}
		else if(request.equals("KILL_SERVICE")){
			System.exit(0);
			return "Shutting down server...\n";
		}
		else return null;
	}
	
}
