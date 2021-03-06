package com.entity;

import java.util.ArrayList;

import com.enums.ActionType;

/**
 * This class includes error constants.
 * the variables initialized with final strings, and they static variables.
 * @author nire
 */
public class GeneralMessages {

	
	/**
	 * General error message.
	 */
	public static final String UNNKNOWN_ERROR = "Unnknown error occureed.";
	
	

	/**
	 * Operation succeeded
	 */
	public static final String OPERATION_SUCCEEDED = "Operation succeeded!";
	
	/**
	 * Operation failed
	 */
	public static final String OPERATION_FAILED = "Operation failed!";
	
	
	/**
	 * Validation of the name
	 */
	public static final String MUST_INCLUDE_ONLY_CHARACTERS = "The name must include only characters.";

	
	/**
	 * Message for user that the ID in not 9 digits.
	 */
	public static final String ONLY_DIGITS_9LEN_ID = "The ID must contain 9 digits only.";


	/**
	 * Message to fill all fields.
	 */
	public static final String MUST_FILL_ALL = "All fields must be filled!";
	
	
	/**
	 * Messafe for invalid phone number.
	 */
	public static final String INVALID_PHONE = "Invalid phone number! Please enter 9 or 10 digits, with no '-'.";
	
	
	/**
	 * Message for invalid email.
	 */
	public static final String INVALID_EMAIL = "Invalid email format.";
	
	/**
	 * Message for invalid car year.
	 */
	public static final String INVALID_CAR_YEAR = "Invalid car year format. Write valid year from 1900.";
	
	/**
	 * Message for invalid house size (square meters).
	 */
	public static final String INVALID_HOUSE_SIZE = "Invalid house size. Use positive number, up to 4 digits.";
	
	/**
	 * Message for no connection to Database
	 */
	public static final String NO_CONNECTION_TO_DB = "Error occurred. Please check your connection to Database.";
	
}
