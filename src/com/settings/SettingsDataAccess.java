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
	public String getHost() { return settings.get(1).getValue(); }
	public void setHost(String path) { settings.get(1).setValue(path); }
	public String getBaseName() { return settings.get(2).getValue(); }
	public void setBaseName(String path) { settings.get(2).setValue(path); }
	public String getUser() { return settings.get(3).getValue(); }
	public void setUser(String path) { settings.get(3).setValue(path); }
	public String getPassword() { return settings.get(4).getValue(); }
	public void setPassword(String path) { settings.get(4).setValue(path); }
	
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
		settings.add(new Setting("Host","localhost"));
		settings.add(new Setting("BaseName","insurance"));
		settings.add(new Setting("User","root"));
		settings.add(new Setting("Password","Braude"));
		
	}

	public void updateDocument() {
		xmlDocument.UpdateDocument(settings);
	}
	
	
}
