package com.control;

import java.io.IOException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.database.CustomerDao;
import com.database.DatabaseController;
import com.entity.Customer;
import com.entity.GeneralMessages;
import com.entity.Validate;
import com.enums.ActionType;
import com.interfaces.ScreensIF;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.StringConverter;

public class SalesController implements ScreensIF {

	
	/**
	 * static variable for insurance cost
	 */
	public static String cost;
	
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
	 * text of insurance type.
	 */
	@FXML private Text typeInsuranceTitle;
	
	/**
	 * text of house size.
	 */
	@FXML private Text houseSizeTitle;
	
	/**
	 * text field of house size.
	 */
	@FXML private TextField houseSizeTextField;
	
	/**
	 * text of car year.
	 */
	@FXML private Text carYearTitle;
	
	/**
	 * text field of car year.
	 */
	@FXML private TextField carYearTextField;
	
	/**
	 * Button for submitting sale info.
	 */
	@FXML private Button submitButton;
	
	/**
	 * Button for celaring all fields.
	 */
	@FXML private Button clearButton;
	
	/**
	 * ComboBox for selecting a customer.
	 */
	@SuppressWarnings("rawtypes")
	@FXML private ComboBox chooseCustomerChoiceBox;
	
	/**
	 * ComboBox for selecting insurance type.
	 */
	@SuppressWarnings("rawtypes")
	@FXML private ComboBox insuranceTypeChoiceBox;
	

	/** initialization of page
	 */
	@SuppressWarnings("unchecked")
	@FXML
	public void initialize()
	{
		ArrayList<Customer> customersList = 
				(new CustomerDao()).getAll();
		chooseCustomerChoiceBox.setItems(FXCollections.observableArrayList(
				customersList));
		
		insuranceTypeChoiceBox.setVisible(false);
		typeInsuranceTitle.setVisible(false);
		carYearTitle.setVisible(false);
		carYearTextField.setVisible(false);
		houseSizeTitle.setVisible(false);
		houseSizeTextField.setVisible(false);
		submitButton.setVisible(false);
		clearButton.setVisible(false);
		
		chooseCustomerChoiceBox.setConverter(new StringConverter<Customer>() {
		    @Override
		    public String toString(Customer object) {
		        return object.getfName() + " " + object.getlName() + " (" + object.getCustomersId() +")";
		    }

		    @Override
		    public Customer fromString(String string) {
		        return null;
		    }
		});	
		
		chooseCustomerChoiceBox.valueProperty().addListener(new ChangeListener<Customer>() {
	        @SuppressWarnings("rawtypes")
			@Override public void changed(ObservableValue ov, Customer oldVal, Customer newVal) {
	        	if(newVal!=null)
	        	{
		              insuranceTypeChoiceBox.setVisible(true);
		              typeInsuranceTitle.setVisible(true);
		              Customer customer = (Customer) chooseCustomerChoiceBox.getValue();
		              String customersId = customer.getCustomersId();
		              try {		 
		            	  System.out.println("*Retriving Insurances");
						ResultSet res=DatabaseController.searchInDatabase("SELECT insuranceType FROM client_insurance WHERE customersId='" + customersId + "'");
			            ArrayList customerInsurances = new ArrayList<String>();
			            ArrayList availableInsurances = new ArrayList<String>();
						while (res.next()) {
							customerInsurances.add(res.getString(1));
						}
						if(!customerInsurances.contains("Car Insurance"))
							availableInsurances.add("Car Insurance");
						if(!customerInsurances.contains("House Insurance"))
							availableInsurances.add("House Insurance");
						if(!customerInsurances.contains("Life Insurance"))
							availableInsurances.add("Life Insurance");
						if(!customerInsurances.contains("Loss of Working Capacity Insurance"))
							availableInsurances.add("Loss of Working Capacity Insurance");
						insuranceTypeChoiceBox.setItems(FXCollections.observableArrayList(
								availableInsurances)
							);
					} catch (SQLException e) {
						System.out.println("*Error retriving Insurances");
						e.printStackTrace();
					}

		              
	        	}

	          }    
	      });
		

		
		insuranceTypeChoiceBox.valueProperty().addListener(new ChangeListener<String>() {
	        @SuppressWarnings("rawtypes")
			@Override public void changed(ObservableValue ov, String oldVal, String newVal) {
	        	if(newVal!=null)
	        	{
		        	if(newVal.equals("Car Insurance"))
		        	{
		        		houseSizeTitle.setVisible(false);
		        		houseSizeTextField.setVisible(false);
		        		carYearTitle.setVisible(true);
		        		carYearTextField.setVisible(true);
		        	}
		        	else if(newVal.equals("House Insurance"))
		        	{
		        		houseSizeTitle.setVisible(true);
		        		houseSizeTextField.setVisible(true);
		        		carYearTitle.setVisible(false);
		        		carYearTextField.setVisible(false);
		        	}
		        	else
		        	{
		        		houseSizeTitle.setVisible(false);
		        		houseSizeTextField.setVisible(false);
		        		carYearTitle.setVisible(false);
		        		carYearTextField.setVisible(false);
		        	}
	        	}

	    		submitButton.setVisible(true);
	    		clearButton.setVisible(true);
	          }    
	      });
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
	 * Handler when pressed "submit". this function submits new customer info to DB.
	 * @param event Gets the ActionEvent when the function called.
	 * @throws IOException IO exception.
	 */
	@FXML
	public void submitButtonPressed(ActionEvent event) throws IOException {
		Boolean res=false;
		Customer customer =  (Customer) chooseCustomerChoiceBox.getSelectionModel().getSelectedItem();
		String insuranceType =  (String) insuranceTypeChoiceBox.getSelectionModel().getSelectedItem();
		String info;
		
		if(insuranceType.equals("Car Insurance"))
		{
			info = carYearTextField.getText().trim();
			if(info.equals(""))
			{
				actionOnError(ActionType.CONTINUE, GeneralMessages.MUST_FILL_ALL);
				return;
			}
			if(Validate.carYearValidate(info)==false)
			{
				actionOnError(ActionType.CONTINUE, GeneralMessages.INVALID_CAR_YEAR);
				return;
			}
		}
			
		else if(insuranceType.equals("House Insurance"))
		{
			info = houseSizeTextField.getText().trim();
			if(info.equals(""))
			{
				actionOnError(ActionType.CONTINUE, GeneralMessages.MUST_FILL_ALL);
				return;
			}
			if(Validate.houseSizeValidate(info)==false)
			{
				actionOnError(ActionType.CONTINUE, GeneralMessages.INVALID_HOUSE_SIZE);
				return;
			}
		}
			
		else
			info=customer.getBirthDate();

		System.out.println("*Updating new Insurance");
		res=DatabaseController.addNewClientInsurance(customer, insuranceType, info);
		if(res)
		{
			clearButtonPressed(event);
			submitButton.setVisible(false);
			clearButton.setVisible(false);
			String msg = GeneralMessages.OPERATION_SUCCEEDED + " Insurance monthly cost: " + SalesController.cost + " ¤";
			actionToDisplay(ActionType.CONTINUE, msg);
			System.out.println("*Insurance Added successfully");
			return;
		}
		else
		{
			actionOnError(ActionType.CONTINUE,GeneralMessages.UNNKNOWN_ERROR);
			System.out.println("*Insurance Adding failed");
			return;
		}
	}
	
	/**
	 * Handler when pressed "clear". this function clears all fields.
	 * @param event Gets the ActionEvent when the function called.
	 * @throws IOException IO exception.
	 */
	@FXML
	public void clearButtonPressed(ActionEvent event) throws IOException {
		insuranceTypeChoiceBox.setVisible(false);
		typeInsuranceTitle.setVisible(false);
		carYearTitle.setVisible(false);
		carYearTextField.setVisible(false);
		houseSizeTitle.setVisible(false);
		houseSizeTextField.setVisible(false);
		submitButton.setVisible(false);
		clearButton.setVisible(false);
		carYearTextField.setText("");
		houseSizeTextField.setText("");
		chooseCustomerChoiceBox.getSelectionModel().clearSelection();
		insuranceTypeChoiceBox.getSelectionModel().clearSelection();
	}

	@Override
	public void pressedCloseMenu(ActionEvent event) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	
		

}

