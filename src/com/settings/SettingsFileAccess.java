package com.settings;


import java.io.File;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class SettingsFileAccess {
	
	private final SAXBuilder saxBuilder = new SAXBuilder();
	private File settingsFile;
	private Document document;
	
	/**
	 * Constructor
	 */
	public SettingsFileAccess(String path) {
		
		createDocument(path);
		
	}	// constructor
	
	/**
	 * initialize settings document
	 * 
	 * @param path
	 */
	private void createDocument(String path)
	{
		settingsFile = new File("input.txt"); 
		if(!settingsFile.exists())
		{
			try {
				settingsFile.createNewFile();
			} catch (IOException e) {
				System.out.println("File Error");
				e.printStackTrace();
			}
		}
		
		try {
			Document document = saxBuilder.build(settingsFile);
		} catch (JDOMException e) {
			System.out.println("XML Error");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO Error");
			e.printStackTrace();
		}
	}	//	createDocument 

}	//	SettingsFileAccess
