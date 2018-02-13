package fr.epita.logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

	private static final String logPath = "/tmp/javaApplications.log";
	private static PrintWriter pw;
	private static final String ERROR = "ERROR";
	private static final String INFO = "INFO";
	
	static 
	{
		try {
			pw = new PrintWriter(new FileOutputStream(new File(logPath),true));
		} catch (final Exception e) {
			
			e.printStackTrace();
		}
	}
	
	private final Class<?> cls;
	
	public Logger(Class<?> cls)
	{
		this.cls = cls;
	}
	
	public void error(String message)
	{
		printMessage(message, ERROR);
	}
	
	public void info(String message)
	{
		printMessage(message, INFO);
	}
	
	
	private void printMessage(String message , String Level)
	{
		final String fullMessage = getTimeStamp() + " - " +cls.getCanonicalName() + " " + message;
		pw.println(fullMessage);
		pw.flush();
	}
	
	private static String getTimeStamp()
	{
		final Date date = new Date();
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss:SS");
		return sdf.format(date);
		
	}
	
	public void error(String message , Exception e)
	{
		printMessage(message, ERROR);
		e.printStackTrace();
		pw.flush();
	}
}
