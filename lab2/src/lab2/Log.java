package lab2;

public class Log {
	
	enum LOG_TYPE {NEW_CONNECTION, CONNECTION_CLOSED, ERROR, MESSAGE_RECEIVED, MESSAGE_SENT};
	
	public static void newMessage(LOG_TYPE type, String message){
		if(type == LOG_TYPE.NEW_CONNECTION){
			System.out.println("NEW CONNECTION: " + message);
		}
		else if(type == LOG_TYPE.CONNECTION_CLOSED){
			System.out.println("CONNNECTION CLOSED: " + message);
		}
		else if(type == LOG_TYPE.ERROR){
			System.err.println("ERROR: " + message);
		}
		else if(type == LOG_TYPE.MESSAGE_RECEIVED){
			System.out.println("MESSAGE_RECEIVED: " + message);
		}
		else if(type == LOG_TYPE.MESSAGE_SENT){
			System.out.println("MESSAGE SENT: " + message);
		}else
		{
			//nothing
		}
	}
}
