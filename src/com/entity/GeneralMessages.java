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
	 * Message for user that the card number must include only numbers.
	 */
	public static final String MUST_INCLUDE_ONLY_DIGIT_CARD = "The card number must include only numbers.";
	
	/**
	 * Message for user that the card number is too short or long.
	 */
	public static final String WRONG_COUNT_OF_DIGIT_CARD = "The card number is too short or too long.";
	
	
	/**
	 * Message for user that the date is wrong.
	 */
	public static final String INVALID_DATE = "The date must include only digit. Format MM for Month and YY for Year";
	
	/**
	 * Message for user that the CVV is wrong.
	 */
	public static final String CVV_INVALID = "The CVV must include only 3 or 4 digit.";
	
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
	 * Messafe for invalid email.
	 */
	public static final String INVALID_EMAIL = "Invalid email format.";
	
}
