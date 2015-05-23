package ainaa.acup.execution;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import ainaa.acup.server.Server;

public class Programming {

	private DataInputStream din;
	private DataOutputStream dout;
	private Process proc;
	private PrintWriter out;
	private BufferedReader in;
	private String shell = "/bin/bash";
	private String lastDirectory = "/home/";

	public Programming() throws IOException {
		din = new DataInputStream(Server.socket.getInputStream());
		dout = new DataOutputStream(Server.socket.getOutputStream());

		proc = Runtime.getRuntime().exec(shell, null, new File(lastDirectory));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
				proc.getOutputStream())), true);
		in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		/* out.println("mkdir .acup/programming"); */
		out.println("whoami");
		out.println("exit");
		String line;
		while ((line = in.readLine()) != null) {

			lastDirectory = lastDirectory + line;
		}
		System.out.println(lastDirectory);
		try {
			proc.waitFor();
			in.close();
			out.close();
			proc.destroy();

		} catch (Exception e) {
			e.printStackTrace();
		}
		proc = Runtime.getRuntime().exec(shell, null, new File(lastDirectory));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
				proc.getOutputStream())), true);
		in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		out.println("mkdir .acup");
		out.println("exit");
		lastDirectory = lastDirectory + "/.acup/";
		try {
			proc.waitFor();
			in.close();
			out.close();
			proc.destroy();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String makeFile(String code, String className) {

		try {
			proc = Runtime.getRuntime().exec(shell, null,
					new File(lastDirectory));
			if (proc != null) {
				// StringBuffer output = new StringBuffer();
				in = new BufferedReader(new InputStreamReader(
						proc.getInputStream()));
				out = new PrintWriter(new BufferedWriter(
						new OutputStreamWriter(proc.getOutputStream())), true);
				out.println("touch prog.java");
				out.println("cat > prog.java");
				out.println(code);
				out.close();
				out = new PrintWriter(new BufferedWriter(
						new OutputStreamWriter(proc.getOutputStream())), true);
				out.println("javac prog.java");
				out.println("java " + className);

				out.println("exit");
				try {
					proc.waitFor();
					in.close();
					out.close();
					proc.destroy();

				} catch (Exception e) {
					e.printStackTrace();
				}
				return runProgram(className);

			} else {

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String runProgram(String className) {
		try {
			proc = Runtime.getRuntime().exec(shell, null,
					new File(lastDirectory));
			if (proc != null) {
				String line;
				StringBuffer output = new StringBuffer();
				in = new BufferedReader(new InputStreamReader(
						proc.getInputStream()));
				out = new PrintWriter(new BufferedWriter(
						new OutputStreamWriter(proc.getOutputStream())), true);

				out.println("javac prog.java");
				out.println("java " + className);

				out.println("exit");
				while ((line = in.readLine()) != null) {
					output.append(line + "\n");
				}
				try {
					proc.waitFor();
					in.close();
					out.close();
					proc.destroy();
					return output.toString();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "some problem";
	}

	public void executeProgram() {
		try {
			while (true) {
				System.out.println("waiting for code to execute");
				String code = din.readUTF();
				int i = code.indexOf("class");
				i += 5;
				int y = code.indexOf("{");
				String className = code.substring(i, y).trim();
				String output = makeFile(code, className);
				dout.writeUTF(output);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
