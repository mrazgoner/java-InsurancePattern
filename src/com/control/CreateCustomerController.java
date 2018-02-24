package com.control;

import java.io.IOException;
import java.time.LocalDate;

import com.database.CustomerDao;
import com.entity.Customer;
import com.entity.GeneralMessages;
import com.entity.Validate;
import com.enums.ActionType;
import com.interfaces.ScreensIF;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CreateCustomerController implements ScreensIF {

	/**
	 * page gets the screen to load in the content pane.
	 */
	@SuppressWarnings("unused")
	private static String page = null;
	
	/**
	 * the main content frame
	 */
	@FXML private AnchorPane content;
	
	
	/**
	 * Button for submitting new customer details.
	 */
	@FXML private Button submitButton;
	
	/**
	 * Button for celaring all fields.
	 */
	@FXML private Button clearButton;

	/**
	 * TextField for first name.
	 */
	@FXML private TextField fNameTextField;
	
	/**
	 * TextField for last name.
	 */
	@FXML private TextField lNameTextField;
	
	/**
	 * TextField for id.
	 */
	@FXML private TextField idTextField;
	
	/**
	 * DatePicker for date of birth.
	 */
	@FXML private DatePicker birthDatePicker;
	
	/**
	 * TextField for address.
	 */
	@FXML private TextField addressTextField;
	
	/**
	 * TextField for phone.
	 */
	@FXML private TextField phoneTextField;
	
	/**
	 * TextField for email.
	 */
	@FXML private TextField emailTextField;

	/*
	 * (non-Javadoc)
	 * 
	 * @see interfaces.ScreensIF#actionOnError(enums.ActionType,
	 * java.lang.String)
	 */
	@Override
	public void actionOnError(ActionType type, String errorCode) {

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText(errorCode);
		alert.showAndWait();
		if (type == ActionType.TERMINATE) {
			Platform.exit();
			System.exit(1);
		}
		if (type == ActionType.CONTINUE)
			return;
	}

	
	

	/**
	 * This function choose what to display the user.
	 * 
	 * @param type Gets the type of action after display.
	 * @param message Gets the message to display in popup.
	 */
	public void actionToDisplay(ActionType type, String message) {

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Info");
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
		if (type == ActionType.TERMINATE) {
			Platform.exit();
			System.exit(1);
		}
		if (type == ActionType.CONTINUE)
			return;
	}
	
	

	
	/**
	 * Handler when pressed "submit". this function submits new customer info to DB.
	 * @param event Gets the ActionEvent when the function called.
	 * @throws IOException IO exception.
	 */
	@FXML
	public void submitButtonPressed(ActionEvent event) throws IOException {
		System.out.println("*Creating new customer");
		Boolean res=false;
		String fName=fNameTextField.getText().trim();
		String lName=lNameTextField.getText().trim();
		String customersId=idTextField.getText().trim();
		String birthDate;
		LocalDate birthDate2=birthDatePicker.getValue();
		if(birthDate2==null)
			birthDate="";
		else
			birthDate=birthDatePicker.getValue().toString();
		String address=addressTextField.getText().trim();
		String phone=phoneTextField.getText().trim();
		String email=emailTextField.getText().trim();
		if(fName.equals("") || lName.equals("") || customersId.equals("")|| birthDate.equals("")
				|| address.equals("") || phone.equals("") || email.equals(""))
		{
			actionOnError(ActionType.CONTINUE, GeneralMessages.MUST_FILL_ALL);
			return;
		}
		else if(Validate.nameValidateCharactersOnly(fName)== false || Validate.nameValidateCharactersOnly(lName)== false)
		{
			actionOnError(ActionType.CONTINUE, GeneralMessages.MUST_INCLUDE_ONLY_CHARACTERS);
			return;
		}
		else if(Validate.idValidate(customersId)==false)
		{
			actionOnError(ActionType.CONTINUE, GeneralMessages.ONLY_DIGITS_9LEN_ID);
			return;
		}
		else if(Validate.phoneValidate(phone)==false)
		{
			actionOnError(ActionType.CONTINUE, GeneralMessages.INVALID_PHONE);
			return;
		}
		else if(Validate.emailValidateString(email)==false)
		{
			actionOnError(ActionType.CONTINUE, GeneralMessages.INVALID_EMAIL);
			return;
		}
		else
		{
			
			Customer customer = new Customer(0,fName,lName,birthDate,address,phone,email, customersId);
			CustomerDao dao = new CustomerDao();
			res= dao.updateInDatabase(customer);
			if(res)
			{
				clearButtonPressed(event);
				System.out.println("*New customer was created: Full Name="
						+ customer.getfName() + " " 
						+ customer.getlName() +" , ID="
						+ customer.getCustomersId());
				actionToDisplay(ActionType.CONTINUE,GeneralMessages.OPERATION_SUCCEEDED);
				return;
			}
			else
			{
				System.out.println("*Failed Creating Customer");
				actionOnError(ActionType.CONTINUE,GeneralMessages.UNNKNOWN_ERROR);
				return;
			}
		}

	}
	
	/**
	 * Handler when pressed "clear". this function clears all fields.
	 * @param event Gets the ActionEvent when the function called.
	 * @throws IOException IO exception.
	 */
	@FXML
	public void clearButtonPressed(ActionEvent event) throws IOException {
		fNameTextField.setText("");
		lNameTextField.setText("");
		idTextField.setText("");
		birthDatePicker.setValue(null);
		addressTextField.setText("");
		phoneTextField.setText("");
		emailTextField.setText("");
		
	}
	


	@Override
	public void pressedCloseMenu(ActionEvent event) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	
		

}

