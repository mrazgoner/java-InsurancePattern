package com.main;

import com.gui.ConsoleScreen;

public class InsurancePattern {

	static ConsoleScreen console;
	static Logger logger;
	static OutStreamPrinter outStream;

	public static void main(String[] args) {

		setupOutput();

		console.setVisible(true);

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
