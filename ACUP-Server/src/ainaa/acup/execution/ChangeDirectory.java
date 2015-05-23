package ainaa.acup.execution;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class ChangeDirectory {
	static Process proc;
	static PrintWriter out;
	static BufferedReader in;
	static String shell = "/bin/bash";
	static String lastDirectory = "/home";

	public String execute(String command) {
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
				out.println(command);
				out.println("pwd");
				out.println("exit");
				while ((line = in.readLine()) != null) {
					output.append(line + "\n");
					lastDirectory = line;
				}
				System.out.println("pwd is " + lastDirectory);
				try {
					proc.waitFor();
					in.close();
					out.close();
					proc.destroy();
					return output.toString();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} catch (Exception e) {

		}
		return "some problem";
	}

}