package ainaa.acup.server;

import ainaa.acup.execution.FileExplorer;
import ainaa.acup.execution.Programming;



public class ClientThread {


	public ClientThread(String mode)
	{
		try
		{
			execute(mode);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public ClientThread()
	{
		try
		{
			
			execute();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private void execute()
	{
		try
		{
			while(true)
			{
				System.out.println("waiting for mode u want to explore");
				String mode = (String)Server.objectIn.readObject();
				System.out.println("recievied mode is "+mode);

				if(mode.trim().equalsIgnoreCase("programming") && Server.pcPlatform.trim().equalsIgnoreCase("ubuntu"))
				{
					new Programming().executeProgram();
				}
				if(mode.trim().equalsIgnoreCase("fileExplorer") && Server.pcPlatform.trim().equalsIgnoreCase("ubuntu"))
				{
					new FileExplorer().executeProgram();
				}
			}
		}catch(Exception e)
		{
			
		}
	}
	private void execute(String mode)
	{
		try
		{
			while(true)
			{
				System.out.println(" mode u want to explore "+mode);
				System.out.println("recievied mode is "+mode);
				
				//Server.dout.writeUTF(output);
			}
		}catch(Exception e)
		{
			
		}
	}
	
}
