package com.control;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.entity.ScreensInfo;
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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

@SuppressWarnings("unused")
public class CustomerServiceController implements ScreensIF {

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
	 * Button for opening a new claim.
	 */
	@FXML private Button newClaimButton;
	
	/**
	 * Button for watching existing claims.
	 */
	@FXML private Button existingClaimsButton;

	/**
	 * static reference of user home page.
	 */
	@SuppressWarnings("unused")
	private static HomepageController userMain;

	

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
	 * Handler when pressed "open a new claim". this function opens the open a new claim page.
	 * @param event Gets the ActionEvent when the function called.
	 * @throws IOException IO exception.
	 */
	@FXML
	public void newClaimButtonPressed(ActionEvent event) throws IOException {
		userMain = new HomepageController();
		HomepageController.setPage(ScreensInfo.OPEN_CLAIM_SCREEN);
		ScreenController screenController = new ScreenController();
		try {
			screenController.replaceSceneContent(ScreensInfo.HOMEPAGE_SCREEN,ScreensInfo.HOMEPAGE_TITLE);
		} catch (Exception e) {
			System.out.println("*failed to load screen");
			e.printStackTrace();
		}	
	}
	
	/**
	 * Handler when pressed "existing claims". this function opens the existing claims page.
	 * @param event Gets the ActionEvent when the function called.
	 * @throws IOException IO exception.
	 */
	@FXML
	public void existingClaimsButtonPressed(ActionEvent event) throws IOException {
		userMain = new HomepageController();
		HomepageController.setPage(ScreensInfo.EXISTING_CLAIMS_SCREEN);
		ScreenController screenController = new ScreenController();
		try {
			screenController.replaceSceneContent(ScreensInfo.HOMEPAGE_SCREEN,ScreensInfo.HOMEPAGE_TITLE);
		} catch (Exception e) {
			System.out.println("*failed to load screen");
			e.printStackTrace();
		}	
	}
	


	@Override
	public void pressedCloseMenu(ActionEvent event) throws IOException {
		 
		
	}
	
	
		

}

