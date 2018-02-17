package com.entity;

import java.util.regex.Pattern;

/**
 * This class validates fields in the application

 */
public class Validate {

	/** 
	 * This static function validates id
	 * @param text Gets string
	 * @return true when the string contains only numbers, and else false.
	 */
	public static boolean idValidate(String text) {
	if (text.matches("[0-9]+") && text.length() == 9) 
		return true;
	
	return false;
	}
	
	/** 
	 * This static function validates phone number
	 * @param text Gets string
	 * @return true when a valid phone was inserted, else false.
	 */
	public static boolean phoneValidate(String text) {
		if (text.matches("[0-9]+") && (text.length() == 9 || text.length() == 10)) 
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
	 * This static function validates email.
	 * @param text Gets string
	 * @return true if valid email was inserted, else false.
	 */
	public static boolean emailValidateString (String text) {
	if(text.isEmpty())
		return true;
	if (text.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) 
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
	
	
}
