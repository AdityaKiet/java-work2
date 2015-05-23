package ainaa.acup.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class Reader {

	Properties props;
	File file;
	InputStream inputStream;
	
	
	public Reader()
	{
		try
		{
			file = new File("config.xml");
		}catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}
	
	public String getPcName() throws IOException
	{
		inputStream = new FileInputStream(file);
		props = new Properties();
		props.loadFromXML(inputStream);
		return props.getProperty("pcName");
	}
	
	public String getPin() throws IOException
	{
		inputStream = new FileInputStream(file);
		props = new Properties();
		props.loadFromXML(inputStream);
		return props.getProperty("pin");
	}
	
	public String getPort() throws IOException
	{
		inputStream = new FileInputStream(file);
		props = new Properties();
		props.loadFromXML(inputStream);
		return props.getProperty("port");
	}
	
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		if(inputStream != null)
		{
			inputStream.close();
		}
	}

	public String getPcPlatform() throws InvalidPropertiesFormatException, IOException {
		inputStream = new FileInputStream(file);
		props = new Properties();
		props.loadFromXML(inputStream);
		return props.getProperty("pcPlatform");
	}
}
