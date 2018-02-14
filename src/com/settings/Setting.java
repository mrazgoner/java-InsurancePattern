package com.settings;

/**
 * Name and value tuple for settings. 
 * 
 * @author Michael
 *
 */

public class Setting {
	
	private String name;
	private String value;

	
	public Setting(String name, String value) 
	{
		this.name = name;
		this.value = value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public void setValue(int value) {
		this.value = "" + value;
	}
	
	public String getName() {
		return name;
	}
	
	
	@Override
	public String toString() {
		return value;
	}
		
}
