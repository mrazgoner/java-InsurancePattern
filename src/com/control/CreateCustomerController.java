package com.control;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.net.URL;
//import java.util.ResourceBundle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.entity.ScreensInfo;
/*
import entity.Author;
import entity.Book;
import entity.GeneralMessages;
import entity.Login;
import entity.Message;
import entity.ScreensInfo;
import entity.User;
*/
import com.enums.ActionType;
import com.interfaces.ScreensIF;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class CreateCustomerController implements ScreensIF {

	/**
	 * page gets the screen to load in the content pane.
	 */
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

	}
	
	/**
	 * Handler when pressed "clear". this function clears all fields.
	 * @param event Gets the ActionEvent when the function called.
	 * @throws IOException IO exception.
	 */
	@FXML
	public void clearButtonPressed(ActionEvent event) throws IOException {

	}
	


	@Override
	public void pressedCloseMenu(ActionEvent event) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	
		

}

