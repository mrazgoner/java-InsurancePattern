package com.gui;

import java.io.IOException;

import com.control.HomepageController;
import com.control.LoggerController;
import com.control.ScreenController;
import com.entity.GeneralMessages;
import com.entity.ScreensInfo;

import com.control.LoggerController;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ClientUI extends Application {


	public static void main(String args[]) {
			Application.launch(ClientUI.class, args);
			
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			//
		     ScreenController.setStage(primaryStage);
			 Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
	
		     ScreenController screenController = new ScreenController();
		     screenController.replaceSceneContent(ScreensInfo.HOMEPAGE_SCREEN,ScreensInfo.HOMEPAGE_TITLE);
		     primaryStage.setResizable(false);
		     primaryStage.show();
			 primaryStage.setX(primaryScreenBounds.getMaxX()/2.0 - primaryStage.getWidth()/2.0);
			 primaryStage.setY(primaryScreenBounds.getMaxY()/2.0 - primaryStage.getHeight()/2.0);
			 
			 /*
			 ScreenController screenController2 = new ScreenController();
			 LoggerController logger = new LoggerController();
			 screenController2.replaceSceneContent(ScreensInfo.LOGGER_SCREEN,ScreensInfo.LOGGER_TITLE);
			 Stage secondStage  = screenController2.getStage();
			 ScreenController.setStage(secondStage);
			 secondStage.show();
			 secondStage.setX(primaryScreenBounds.getMaxX()/2.0 - secondStage.getWidth()/2.0);
			 secondStage.setY(primaryScreenBounds.getMaxY()/2.0 - secondStage.getHeight()/2.0);
			 */
			 
		     } catch (Exception e) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Error");
				alert.setHeaderText(null);
				alert.setContentText(GeneralMessages.UNNKNOWN_ERROR);
				alert.showAndWait();
				return;
		        }
	}

	
}
