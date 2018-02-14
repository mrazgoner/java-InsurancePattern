package com.main;

import java.util.ArrayList;

import com.gui.ConsoleScreen;
import com.settings.Setting;
import com.settings.SettingsXMLFile;

public class InsurancePattern {

	static ConsoleScreen console;
	static Logger logger;
	static OutStreamPrinter outStream;

	public static void main(String[] args) {

		setupOutput();

		console.setVisible(true);
		
		ArrayList<Setting> list1  = new ArrayList<Setting>();
		ArrayList<Setting> list2  = new ArrayList<Setting>();
		
		list1.add(new Setting("name","123"));
		list2.add(new Setting("name","345"));
		
		SettingsXMLFile test = new SettingsXMLFile("test.xml");
		test.UpdateDocument(list1);
		test.parseDocument(list2);

	}

	
	static private void setupOutput()
	{
		console = new ConsoleScreen();
		logger = new Logger("default.txt");
		outStream = new OutStreamPrinter();

		outStream.addObserver(console);
		outStream.addObserver(logger);

		System.setOut(outStream.getPrintStream());
		
		
	}

}
