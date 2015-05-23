import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;


public class Try {

	/*static DataInputStream din;
	static ObjectOutputStream objectOut;
	static Process proc;
	static PrintWriter out;
	static BufferedReader in;
	static String shell = "/bin/bash";
	static String lastDirectory = "/home/";
	static ArrayList<String> directoryList = new ArrayList<String>();
	static StringBuffer s = new StringBuffer();
	public static void main(String[] args) throws IOException {
		proc = Runtime.getRuntime().exec(shell, null, new File(lastDirectory));
		 out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(proc.getOutputStream())), true);
		 in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		 out.println("cd abhishek");
		 out.println("ls");
		 out.println("exit");
		 String line;
		while ((line = in.readLine()) != null) {
				
			s.append(line+"\n");
			}
		System.out.println("output is \n"+s);
		try {
			proc.waitFor();
			in.close();
			out.close();
			proc.destroy();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}*/
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException {
		@SuppressWarnings("resource")
		Socket socket = new Socket("192.168.0.104", 8000);
		System.out.println("check point1");

		ObjectOutputStream dout = new ObjectOutputStream(socket.getOutputStream());		System.out.println("check point2");

		ObjectInputStream objectIn = new ObjectInputStream(socket.getInputStream());
		System.out.println("check point");
		dout.writeObject(new String("authenticate"));
		dout.writeObject("ainaa");
		dout.writeObject("fileExplorer");
		ArrayList<String> a = (ArrayList<String>)objectIn.readObject();
		System.out.println("result is "+a.toString());
	}
}
