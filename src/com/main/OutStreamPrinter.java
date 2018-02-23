package com.main;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;



public class OutStreamPrinter extends OutputStream {

	private PrintStream printStream;
	private ArrayList<PrintObserver> observers = new ArrayList<PrintObserver>();

	public OutStreamPrinter() {
		super();
		setPrintStream(new PrintStream(this));
	}
	
	public void addObserver(PrintObserver obs) {
		observers.add(obs);
	}
	
	public void remove(PrintObserver obs) {
		observers.remove(obs);
	}

	@Override
	public void write(int b) throws IOException {
		if(b == (int)'\n')
			NotifyWrite(" [" + (new Date()).toString() + "]");
		NotifyWrite(String.valueOf((char)b));


		
	}

	private void NotifyWrite(String str)
	{
		for(PrintObserver obs : observers) {
			obs.append(str);
		}
		
	}

	public PrintStream getPrintStream() {
		return printStream;
	}

	private void setPrintStream(PrintStream printStream) {
		this.printStream = printStream;
	}

}