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
import com.control.HomepageController;
import com.control.ScreenController;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ExistingClaimsController implements ScreensIF {

	/**
	 * page gets the screen to load in the content pane.
	 */
	private static String page = null;
	
	/**
	 * the main content frame
	 */
	@FXML private AnchorPane content;
	
	/**
	 * Table of existing claims  
	 */
	@FXML public TableView resultsTable;
	
	/**
	 * Column of claim's id 
	 */
	@FXML public TableColumn claimNumberCol;
	
	/**
	 * Column of claim type
	 */
	@FXML public TableColumn claimTypeCol;
	
	/**
	 * Column of first name of claim opener
	 */
	@FXML public TableColumn fNameCol;

	/**
	 * Column of last name of claim opener
	 */
	@FXML public TableColumn lNameCol;
	
	/**
	 * Column of claim opener
	 */
	@FXML public TableColumn claimContentCol;
	
	/**
	 * Column of claim status
	 */
	@FXML public TableColumn claimStatusCol;
	
	/**
	 * Column of closing claim
	 */
	@FXML public TableColumn closeClaimCol;
	
	/**
	 * static reference of user home page.
	 */
	private static HomepageController userMain;

	/**
	 * back Button for last page.
	 */
	@FXML private Button backButton;
	

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
	

	
	/** When pressed, takes user back to customer service page.
	 * @author itain
	 * @param event Gets event.
	 */
	public void backButtonPressed(ActionEvent event) {		
		userMain = new HomepageController();
		userMain.setPage(ScreensInfo.CUSTOMER_SERVICE_SCREEN);
		ScreenController screenController = new ScreenController();
		try {
			screenController.replaceSceneContent(ScreensInfo.HOMEPAGE_SCREEN,ScreensInfo.HOMEPAGE_TITLE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	


	@Override
	public void pressedCloseMenu(ActionEvent event) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	
		

}

