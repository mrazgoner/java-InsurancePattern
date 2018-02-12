package com.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger implements PrintObserver {

	private File logFile;
	private FileWriter writer;
	private BufferedWriter buffer;

	public Logger(String path) 
	{
		setLogFile(path);
		
	}

	public void append(String str) {	
		try {
			buffer.write(str);
			buffer.flush();
		} catch (IOException e) {
			System.out.println("failed writing to log file");
			e.printStackTrace();
		}	
	}

	private void createStream()
	{
		try {
			writer =  new FileWriter(logFile.getAbsoluteFile(),true);
			buffer = new BufferedWriter(writer);
		} catch ( IOException e) {
			System.out.println("error creating file stream, file not found");
			e.printStackTrace();
		}
	}

	public File getLogFile() {
		return logFile;
	}

	public void setLogFile(String path) {
		this.logFile = new File(path);
		
		if(!logFile.exists())
		{
			try {
				logFile.createNewFile();
			} catch (IOException e) {
				System.out.println("error creating file");
				e.printStackTrace();
			}
		}
		createStream();
	}

}
