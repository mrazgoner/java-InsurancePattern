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
import javafx.scene.text.Font;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class HomepageController implements ScreensIF {

	/**
	 * page gets the screen to load in the content pane.
	 */
	private static String page = null;
	
	/**
	 * the main content frame
	 */
	@FXML private AnchorPane content;
	
	/**
	 * Button for sales.
	 */
	@FXML private Button salesButton;
	
	/**
	 * special font.
	 */
	@FXML private Font x1;
	
	/**
	 * Button for customer service.
	 */
	@FXML private Button customerServiceButton;
	
	/**
	 * Button for creating a new customer.
	 */
	@FXML private Button createNewCustomerButton;
	
	/**
	 * Button for showing the logger.
	 */
	@FXML private Button loggerButton;

	/**
	 * logo of application.
	 */
	@FXML private ImageView logoImgView;
	
	/**
	 * saves the subscription info.
	 */
	private static ArrayList<String> subscription;
	
	
    /**
     * initialize page variable
     */
    public void initialize() {
		if (page != null)
		 {
			try {
				loadPage(page);
				page=null;
			} catch (IOException e) {
				e.printStackTrace();
			} 
		 }
    }

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
	 * when pressed, load the external payment company screen.
	 * @throws Exception
	 */
	public void btnPayForSubscriptionPressed() throws Exception
	{	
		try 
		{
			ScreenController screenController = new ScreenController();
        	ExternalPaymentController extPayment = new ExternalPaymentController();
        	extPayment.setProduct(subscription.get(0).toString() + " Subscription");
        	if(subscription.get(0).toString().equals("Monthly"))
        	{
        		extPayment.setPrice("250");
        		extPayment.setAction(4);	//Buy monthly subscription.
        	}
        	else
        	{
        		extPayment.setPrice("2800");
        		extPayment.setAction(5);	//Buy yearly subscription.
        	}
        	//extPayment.searchedBookPage = searchedBookPage;
        	        			        	
			screenController.replaceSceneContent(ScreensInfo.EXTERNAL_PAYMENT_SCREEN,ScreensInfo.EXTERNAL_PAYMENT_TITLE);
			Stage primaryStage = screenController.getStage();
			ScreenController.setStage(primaryStage);
			Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
			primaryStage.show();
			primaryStage.setX(primaryScreenBounds.getMaxX()/2.0 - primaryStage.getWidth()/2.0);
			primaryStage.setY(primaryScreenBounds.getMaxY()/2.0 - primaryStage.getHeight()/2.0);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Handler when pressed "sales". this function open the sales page.
	 * @param event Gets the ActionEvent when the function called.
	 * @throws IOException IO exception.
	 */
	@FXML
	public void salesButtonPressed(ActionEvent event) throws IOException {
		loadPage(ScreensInfo.SALES_SCREEN);
	}
	
	/**
	 * Handler when pressed "customer service". this function open the customer service page.
	 * @param event Gets the ActionEvent when the function called.
	 * @throws IOException IO exception.
	 */
	@FXML
	public void customerServiceButtonPressed(ActionEvent event) throws IOException {
		loadPage(ScreensInfo.CUSTOMER_SERVICE_SCREEN);
	}
	
	/**
	 * Handler when pressed "logger". this function opens the logger page.
	 * @param event Gets the ActionEvent when the function called.
	 * @throws IOException IO exception.
	 */
	@FXML
	public void loggerButtonPressed(ActionEvent event) throws IOException {
		loadPage(ScreensInfo.LOGGER_SCREEN);
	}
	
	
	/**
	 * Handler when pressed "create new customer". this function open the create new customer form.
	 * @param event Gets the ActionEvent when the function called.
	 * @throws IOException IO exception.
	 */
	@FXML
	public void createNewCustomerButtonPressed(ActionEvent event) throws IOException {
		loadPage(ScreensInfo.CREATE_CUSTOMER_SCREEN);
	}

	@Override
	public void pressedCloseMenu(ActionEvent event) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	
		

}

