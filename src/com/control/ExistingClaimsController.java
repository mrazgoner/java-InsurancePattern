package com.control;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.net.URL;
//import java.util.ResourceBundle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.entity.Claim;
import com.entity.GeneralMessages;
import com.entity.ScreensInfo;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.enums.ActionType;
import com.interfaces.ScreensIF;
import com.control.HomepageController;
import com.control.ScreenController;
import com.database.DatabaseController;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Callback;

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
	@FXML public TableView claimsTable;
	
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
	 * Column of claim opener id
	 */
	@FXML public TableColumn customersIdCol;
	
	
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
	

	/** initialization of page
	 */
	@FXML
	public void initialize()
	{
		ObservableList<Claim> existingClaims = FXCollections.observableArrayList();
		try {
			System.out.println("*Getting list of claims from Database");
			ResultSet res=DatabaseController.searchInDatabase("SELECT * FROM client_claim");
			while (res.next()) {
				String status;
				if(res.getInt(5)==1)
					status="Open";
				else
					status="Closed";
				Claim claim = new Claim(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), status);
				
				//get first and last name of client
				ResultSet res2=DatabaseController.searchInDatabase("SELECT fName, lName FROM client WHERE customersId='" + claim.getCustomersId() + "'");
				while (res2.next()) {
					claim.setfName(res2.getString(1));
					claim.setlName(res2.getString(2));	
				}

				existingClaims.add(claim);

			}
			claimStatusCol.setSortType(TableColumn.SortType.DESCENDING);
			
			claimNumberCol.setCellValueFactory(
	                new PropertyValueFactory<Claim, Integer>("id"));
			
			claimTypeCol.setCellValueFactory(
	                new PropertyValueFactory<Claim, String>("claimType"));
			
			fNameCol.setCellValueFactory(
	                new PropertyValueFactory<Claim, String>("FName"));
			
			lNameCol.setCellValueFactory(
	                new PropertyValueFactory<Claim, String>("LName"));
			
			customersIdCol.setCellValueFactory(
	                new PropertyValueFactory<Claim, String>("customersId"));	
			
			claimContentCol.setCellValueFactory(
	                new PropertyValueFactory<Claim, String>("content"));
			
			claimStatusCol.setCellValueFactory(
	                new PropertyValueFactory<Claim, String>("status"));
			
			claimsTable.setItems(existingClaims);
			claimsTable.getSortOrder().add(claimStatusCol);
			
			closeClaimCol.setCellValueFactory(new PropertyValueFactory<>("closeClaim"));

		        Callback<TableColumn<Claim, String>, TableCell<Claim, String>> cellFactory
		                = //
		                new Callback<TableColumn<Claim, String>, TableCell<Claim, String>>() {
		            @Override
		            public TableCell call(final TableColumn<Claim, String> param) {
		                final TableCell<Claim, String> cell = new TableCell<Claim, String>() {
		                	
		                	
		                    final Button btn = new Button("Close");
		                    @Override
		                    public void updateItem(String item, boolean empty) {
		                        super.updateItem(item, empty);
		                        if (empty) {
		                            setGraphic(null);
		                            setText(null);
		                        } else {
		                        	Claim claim = getTableView().getItems().get(getIndex());
		                        	if(claim.getStatus().equals("Open"))
		                        	{
			                            btn.setOnAction(event -> {
			                            	
			                            	try {
												DatabaseController.updateDatabase("UPDATE client_claim SET status='" + 0 + "' WHERE id=" + claim.getId() + " AND customersId=" + claim.getCustomersId());
												System.out.println("*Successfully changed status of claim " + claim.getId() + " to closed in Database");
												actionToDisplay(ActionType.CONTINUE,GeneralMessages.OPERATION_SUCCEEDED);
												initialize();
												return;
			                            	} catch (Exception e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
			                                

			                                        
			                            });
			                            setGraphic(btn);
			                            setText(null);
		                        	}
		                        	else
		                        	{
			                            setGraphic(null);
			                            setText(null);
		                        	}


		                        }
		                        
		                    }
		                };
		                return cell;
		            }
		        };
		        closeClaimCol.setCellFactory(cellFactory);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

