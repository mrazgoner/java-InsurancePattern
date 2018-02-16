package com.gui;

import java.io.IOException;

import com.control.HomepageController;
import com.control.LoggerController;
import com.control.ScreenController;
import com.entity.GeneralMessages;
import com.entity.ScreensInfo;

import com.control.LoggerController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class ClientUI extends Application {


	public static void main(String args[]) {
		Application.launch(args);
			
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
		     
			 primaryStage.setX(primaryScreenBounds.getMaxX()/2.0 - primaryStage.getWidth()/2.0);
			 primaryStage.setY(primaryScreenBounds.getMaxY()/2.0 - primaryStage.getHeight()/2.0);
			 
			 
		    FXMLLoader loader = new FXMLLoader(getClass().getResource(ScreensInfo.LOGGER_SCREEN));
	        Scene newScene;
	        try {
	            newScene = new Scene(loader.load());
	        } catch (IOException ex) {
	            // TODO: handle error
	            return;
	        }
	        Stage inputStage = new Stage();
	        inputStage.initOwner(primaryStage);
	        inputStage.setScene(newScene);
	        inputStage.show();
	        inputStage.setResizable(false);
	        //inputStage.setOnCloseRequest(e->e.consume());

	        primaryStage.show();
			 //screenController.replaceSceneContent(ScreensInfo.LOGGER_SCREEN,ScreensInfo.LOGGER_TITLE);

			 
			 
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
