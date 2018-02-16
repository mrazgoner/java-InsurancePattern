package com.main;


import java.util.Date;

import com.database.DatabaseConnnector;
import com.gui.ConsoleScreen;
import com.settings.SettingsDataAccess;

public class InsurancePattern {
	
	static ConsoleScreen console;
	static Logger logger;
	static OutStreamPrinter outStream;
	static SettingsDataAccess settings;

	public static void main(String[] args) {
		
		setupOutput();

		console.setVisible(true);
		settings = new SettingsDataAccess("settings.xml");
		logger = new Logger(settings.getLoggerPath());
		outStream.addObserver(logger);
		
		
		DatabaseConnnector.initialize(
				settings.getHost(),
				settings.getBaseName(), 
				settings.getUser(), 
				settings.getPassword());
		
		
		System.out.println(new Date());
		

	}

	
	static private void setupOutput()
	{
		console = new ConsoleScreen();
		outStream = new OutStreamPrinter();

		outStream.addObserver(console);

		System.setOut(outStream.getPrintStream());
		
		
	}

}
