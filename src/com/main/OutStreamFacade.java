package com.main;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import com.gui.ConsoleScreen;


public class OutStreamFacade extends OutputStream {

	private PrintStream printStream;
	private ConsoleScreen screen;
	private Logger logger;

	public OutStreamFacade(ConsoleScreen screen, Logger logger) {
		super();
		setPrintStream(new PrintStream(this));
		setLogger(logger);
		setScreen(screen);
	}

	@Override
	public void write(int b) throws IOException {
		facadeWrite(String.valueOf((char)b));
	}

	private void facadeWrite(String str)
	{
		logger.append(str);
		screen.append(str);
		
	}

	public PrintStream getPrintStream() {
		return printStream;
	}

	private void setPrintStream(PrintStream printStream) {
		this.printStream = printStream;
	}

	public ConsoleScreen getScreen() {
		return screen;
	}

	public void setScreen(ConsoleScreen screen) {
		this.screen = screen;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

}