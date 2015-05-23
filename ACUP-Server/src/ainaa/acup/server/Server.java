package ainaa.acup.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static int port;
	public static String pin;
	public static ObjectInputStream objectIn;
	public static ObjectOutputStream objectOut;
	public static String pcName;
	public static String pcPlatform;
	public static Socket socket;
	 ServerSocket serverSocket;
	
	public Server()
	{
		try
		{
			serverSocket = new ServerSocket(port);
			System.out.println("listening at "+serverSocket);
			while(true)
			{
				socket = serverSocket.accept();
				objectIn = new ObjectInputStream(socket.getInputStream());
				objectOut = new ObjectOutputStream(socket.getOutputStream());
				System.out.println("connected client "+socket);
				
				
				String task = (String)objectIn.readObject();
				System.out.println("checking for token");
				if(task.equalsIgnoreCase("check"))
						{
					System.out.println("for check");
					objectOut.writeObject(new String(Server.pcName));
					objectOut.writeObject(new String("linux"));
					System.out.println("pc name is written");
					continue;
						}
				if(task.equalsIgnoreCase("authenticate"))
				{
					System.out.println("authenticate started");
					new Authenticate(socket);
				}
				
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
