package com.settings;

import java.io.File;
import java.util.ArrayList;


/**
 * 
 * data access object for settings stored in the XML file
 * 
 */
public class SettingsDataAccess {
	
	private SettingsXMLFile xmlDocument;
	private ArrayList<Setting> settings;
	
	public String getLoggerPath() { return settings.get(0).getValue(); }
	public void setLoggerPath(String path) { settings.get(0).setValue(path); }
	
	/**
	 * Tries to read from given file, 
	 * if file is invalid creates a new file with default settings
	 * 
	 * @param path
	 */
	public SettingsDataAccess(String path)
	{
		xmlDocument = new SettingsXMLFile(path);
		set_defaults();
		
		System.out.println("Reading\\Creating Settings");
		
		File file = new File(path);
		if (file.exists())
		{
			/*
			 * try to read the existing settings file
			 * 
			 */
			if(xmlDocument.parseDocument(settings)==null)
			{
				/* 
				 * if the XML is invalid
				 */
				set_defaults();
				xmlDocument.UpdateDocument(settings);
			}
		}
		else
		{
			xmlDocument.UpdateDocument(settings);	
		}
				
		System.out.println("Settings are:");
		System.out.print(this.toString());
		
	}
	
	@Override
	public String toString() {
		String str = "";
		
		for(Setting field : settings)
		{
			str += " " + field.toString() +"\n";
		}
		
		return str;
	}


	/**
	 * initialize default settings list
	 * 
	 * TODO put the actual settings, and later access methods for each
	 */
	private void set_defaults() {
		settings = new ArrayList<Setting>();
		settings.add(new Setting("LoggerPath","logger.txt"));
		settings.add(new Setting("field2","default2"));
		
	}

	
	
}
