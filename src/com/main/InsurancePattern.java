package com.main;

import com.gui.ConsoleScreen;

public class InsurancePattern {
	
	static ConsoleScreen console = new ConsoleScreen();
	static Logger logger = new Logger();
	static OutStreamFacade outStream = new OutStreamFacade(console, logger);

	public static void main(String[] args) {
		console.setVisible(true);
		System.setOut(outStream.getPrintStream());
		System.out.println("test");
		///
		
	}

}
