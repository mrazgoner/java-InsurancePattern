package com.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import com.control.HomepageController;
import com.control.LoggerController;
import com.control.ScreenController;
import com.database.DatabaseController;
import com.entity.GeneralMessages;
import com.entity.ScreensInfo;
import com.gui.ConsoleScreen;
import com.settings.SettingsDataProxy;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class InsurancePattern extends Application {

	public LoggerController loggerController;

	static Logger logger;
	static OutStreamPrinter outStream;
	static SettingsDataProxy settings;
	public static ConsoleScreen console;

	public static void main(String args[]) {
		Application.launch(args);

	}

	@Override
	public void start(Stage primaryStage) {
		try {
			
			setupOutput();
		
			settings = new SettingsDataProxy("settings.xml");
			logger = new Logger(settings.getLoggerPath());
			outStream.addObserver(logger);

			connectToDB();
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


	private void setupOutput()
	{
		outStream = new OutStreamPrinter();
		console = new ConsoleScreen();
		outStream.addObserver(console);
		console.setVisible(false);
		System.setOut(outStream.getPrintStream());


	}


	public void connectToDB() throws IOException {
		try {
			DatabaseController databaseController = new DatabaseController();
			databaseController.SetConnection(
					settings.getHost(),
					settings.getBaseName(), 
					settings.getUser(), 
					settings.getPassword());


			System.out.println("Connected to database successfully");
		} catch (Exception e) {
			System.out.println("SQL connection Failed");
			return;
		}
		return;


	}

	/**
	 * This function send the parameter to file, and to I/O after getting the
	 * time. it appends the string.
	 * @param msg Gets themessage that will be write in log file, and into server GUI.
	 */
	//void writeToLog(String msg) {
	//	Date datelog = new Date();
	//	logger.info(msg);
//		loggerController.logField.appendText(datelog.toString() + " " + msg + "\n");
//	}


}
