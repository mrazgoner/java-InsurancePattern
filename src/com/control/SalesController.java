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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class SalesController implements ScreensIF {

	/**
	 * page gets the screen to load in the content pane.
	 */
	private static String page = null;
	
	/**
	 * the main content frame
	 */
	@FXML private AnchorPane content;
	
	/**
	 * text of insurance type.
	 */
	@FXML private Text typeInsuranceTitle;
	
	/**
	 * Button for car insurance.
	 */
	@FXML private Button carInsuranceButton;
	
	/**
	 * Button for house insurance.
	 */
	@FXML private Button houseInsuranceButton;

	/**
	 * Button for life insurance.
	 */
	@FXML private Button lifeInsuranceButton;
	
	/**
	 * Button for loss of Working capacity Insurance.
	 */
	@FXML private Button lossWorkingInsuranceButton;
	
	/**
	 * ComboBox for selecting a customer.
	 */
	@FXML private ComboBox chooseCustomerChoiceBox;
	

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
	 * this method load the page to the content AnchorPane.
	 * @param screenPath The path of the next screen.
	 * @throws IOException IO exception.
	 */
	@FXML
	public void loadPage(String screenPath) throws IOException {
				try {
					if(content.getChildren().size()>0)
						content.getChildren().remove(0);
					Parent root = FXMLLoader.load(getClass().getResource(screenPath));
					content.getChildren().add(root);
				} catch (Exception e) {
					e.printStackTrace();
				}
	}
	
	/** Setter for page.
	 * @param page The page that load in the AnchorPane.
	 */
	public static void setPage(String pageToLoad)
	{
		page = pageToLoad;
	}
	
	/** Getter for page.
	 * @return The page that load in the AnchorPane.
	 */
	public String getPage()
	{
		return page;
	}

	

	
	/**
	 * Handler when pressed "car Insurance". this function applies a car insurance for a chosen customer.
	 * @param event Gets the ActionEvent when the function called.
	 * @throws IOException IO exception.
	 */
	@FXML
	public void carInsuranceButtonPressed(ActionEvent event) throws IOException {
		
	}
	
	/**
	 * Handler when pressed "house Insurance". this function applies a house insurance for a chosen customer.
	 * @param event Gets the ActionEvent when the function called.
	 * @throws IOException IO exception.
	 */
	@FXML
	public void houseInsuranceButtonPressed(ActionEvent event) throws IOException {
		
	}
	
	/**
	 * Handler when pressed "life Insurance". this function applies a life insurance for a chosen customer.
	 * @param event Gets the ActionEvent when the function called.
	 * @throws IOException IO exception.
	 */
	@FXML
	public void lifeInsuranceButtonPressed(ActionEvent event) throws IOException {
		
	}
	
	/**
	 * Handler when pressed "loss of Working capacity Insurance". 
	 * this function applies a loss of Working capacity Insurance for a chosen customer.
	 * @param event Gets the ActionEvent when the function called.
	 * @throws IOException IO exception.
	 */
	@FXML
	public void lossWorkingInsuranceButtonPressed(ActionEvent event) throws IOException {
		
	}
	
	/**
	 * Handler when a customer was chosen from the chice box.
	 * this function shows insurance types after a customer was chosen.
	 * @param event Gets the ActionEvent when the function called.
	 * @throws IOException IO exception.
	 */
	@FXML
	public void CustomerChosen(ActionEvent event) throws IOException {
		
	}

	@Override
	public void pressedCloseMenu(ActionEvent event) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	
		

}

