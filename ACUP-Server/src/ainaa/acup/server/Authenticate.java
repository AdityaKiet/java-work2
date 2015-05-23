package ainaa.acup.server;

import java.net.Socket;


public class Authenticate extends Thread {

	Socket socket;
	int attempts = 1;
	public Authenticate(Socket socket) {
		this.socket = socket;
		start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try
		{
			startSession();
		}catch(Exception e)
		{
			e.printStackTrace(); 
		}
	}
	
	private void startSession()
	{
		while(true)
		{
		try
		{
			{
			String pin = "ainaa";
			System.out.println("after pin "+pin);
			if(pin.equalsIgnoreCase(Server.pin))
			{
				Server.objectOut.writeObject(new String("success"));
				System.out.println("success");
				new ClientThread();
				return;
			}
			else if(attempts == 5)
			{
				Server.objectOut.writeObject(new String("you entered wrong username password more than your attempts"));
				//socket.close();
				return;
			}
			
			else
			{
				Server.objectOut.writeObject(new String("you entered wrong username and password and remaining attempts is "+(5-attempts)));
				attempts++;
			}
			}
			
 		}catch(Exception e)
		{
 			e.printStackTrace();
		}
		}
	}
}
