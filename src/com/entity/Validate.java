package com.entity;

import java.util.regex.Pattern;

/**
 * This class validates fields in the application

 */
public class Validate {

	/** 
	 * This static function validate the credit card owner.
	 * @param text Gets string
	 * @return true when the string contains only numbers, and else false.
	 */
	public static boolean usernameValidate(String text) {
	if (text.matches("[0-9]+") && text.length() == 9) 
		return true;
	
	return false;
	}
	
	/** 
	 * This static function validates name for characters only.
	 * @param text Gets string
	 * @return true when the string contains only characters, and else false.
	 */
	public static boolean nameValidateCharactersOnly(String text) {
	if(text.isEmpty())
		return true;
	if (text.matches("[A-Za-z\\s]+")) 
		return true;
	
	return false;
	}
	
	/**
	 * This static function validate the credit card number.
	 * @param text Gets the text.
	 * @return the answer.
	 */
	public static boolean cardNumberValidate(String text) {
	if (text.matches("[0-9]+")) 
		return true;
	return false;
	}
	
	/**
	 * This static function validate if inserted 2 digits.
	 * @param text Gets the text.
	 * @return the answer.
	 */
	public static boolean twoDigitValidate(String text) {
	if (text.matches("[0-9]+") && text.length() == 2) 
		return true;
	
	return false;
	}
	
	/**
	 * This static function validate for CVV.
	 * @param text Gets the text.
	 * @return the answer.
	 */
	public static boolean cvvValidate(String text) {
	if (text.matches("[0-9]+") && (text.length() == 3 || text.length() == 4 )) 
		return true;
	
	return false;
	}
	
	/**
	 * Get string and add apostrophe beside of every apostrophe in the text to fix
	 * writing to DB problem.
	 * @param str The text that have fix.
	 * @return The text after fixing.
	 */
	public static String fixText(String str)
	{
		for(int i=0;i<str.length()-1;i++){
			if(str.charAt(i)=='\'' && str.charAt(i+1)=='\''){
				str = str.substring(0,i) + "\"" +  str.substring(i+2,str.length());
			}
		}
		str = str.replace("'", "''");
		return str;
	}
	
}
