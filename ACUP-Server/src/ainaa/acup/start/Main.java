package ainaa.acup.start;

import ainaa.acup.config.Reader;
import ainaa.acup.server.Server;

public class Main {

	public static void main(String[] args) {
		Reader reader = new Reader();
		try
		{
			Server.port = Integer.parseInt(reader.getPort());
			Server.pin = reader.getPin();
			Server.pcName = reader.getPcName();
			Server.pcPlatform = reader.getPcPlatform();
			new Server();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
