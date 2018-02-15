package com.main;


import java.util.Date;

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
