package ainaa.acup.execution;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import ainaa.acup.dto.FileExplorerDTO;
import ainaa.acup.server.Server;

public class FileExplorer {

	private Process proc;
	private PrintWriter out;
	private BufferedReader in;
	private String shell = "/bin/bash";
	private String lastDirectory = "/home/";
	private ArrayList<FileExplorerDTO> files ;
	private StringBuffer sb = new StringBuffer();
	
	public FileExplorer() throws IOException
	{
		proc = Runtime.getRuntime().exec(shell, null, new File(lastDirectory));
		 out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(proc.getOutputStream())), true);
		 in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		 files = new ArrayList<FileExplorerDTO>();
		 setHome();
		 startSession();
	}
	
	private void setHome() throws IOException
	{
		 out.println("whoami");
		 out.println("exit");
		 String line;
		while ((line = in.readLine()) != null) {
				
			lastDirectory = lastDirectory + line;
			}
		
		try {
			proc.waitFor();
			in.close();
			out.close();
			proc.destroy();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("changed directory "+lastDirectory);
	}
	
	private void startSession() throws IOException
	{
		proc = Runtime.getRuntime().exec(shell, null, new File(lastDirectory));
		 out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(proc.getOutputStream())), true);
		 in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		 out.println("ls");
		 out.println("exit");
		 String line;
		while ((line = in.readLine()) != null) {
			sb.append(line);
			}
		parseFileData(sb.toString());
		try {
			proc.waitFor();
			in.close();
			out.close();
			proc.destroy();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		Server.objectOut.writeObject(files);
	
	}
	
	
	private void execute(String directory) throws IOException
	{
		/*proc = Runtime.getRuntime().exec(shell, null, new File(lastDirectory));
		 out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(proc.getOutputStream())), true);
		 in = new BufferedReader(new InputStreamReader(proc.getInputStream()));*/
		 out.println("cd "+directory);
		 out.println("ls");
		 out.println("exit");
		 String line;
		while ((line = in.readLine()) != null) {
				
			sb.append(line);
			}
		parseFileData(sb.toString());
		try {
			proc.waitFor();
			in.close();
			out.close();
			proc.destroy();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	


	public void executeProgram() {
		try{
		while(true)
		{
			System.out.println("waiting for code to execute");
			String code = (String)Server.objectIn.readObject();
			execute(code);
			Server.objectOut.writeObject(files);
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	
	
	private void parseFileData(String outputData)
	{
		
		String lines[] = outputData.split("\\r?\\n");
		for(int i = 0; i <lines.length; i++)
		{
			FileExplorerDTO file = new FileExplorerDTO();
			file.setName(lines[i]);
			files.add(file);
		}

	}
}
