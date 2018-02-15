package com.gui;
//
import java.io.IOException;

import com.control.HomepageController;
import com.control.ScreenController;
import com.entity.GeneralMessages;
import com.entity.ScreensInfo;
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
		     ScreenController.setStage(primaryStage);
			 Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
	
		     ScreenController screenController = new ScreenController();
		     screenController.replaceSceneContent(ScreensInfo.HOMEPAGE_SCREEN,ScreensInfo.HOMEPAGE_TITLE);
		     primaryStage.setResizable(false);
		     primaryStage.show();
			 primaryStage.setX(primaryScreenBounds.getMaxX()/2.0 - primaryStage.getWidth()/2.0);
			 primaryStage.setY(primaryScreenBounds.getMaxY()/2.0 - primaryStage.getHeight()/2.0);
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
