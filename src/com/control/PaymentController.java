package com.control;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import com.entity.GeneralMessages;
import com.entity.ScreensInfo;
import com.enums.ActionType;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * PaymentController is the controller that responsible for get answer from the external
 * payment company and make the purchase in DB.
 *
 */
public class PaymentController {
	
	/**
	 * Get answer from DB if the action was success.
	 */
	public static boolean success=false;
	
	/**
	 * static reference of user home page.
	 */
	private static HomepageController userMain;
	
	
	/*
	 * Action list:
	 * 1: PerBook - buy book. - called from ExternalPaymentController.
	 * 2: Monthly - buy book. - called from BookPageController.
	 * 3: Yearly - buy book. - called from BookPageController.
	 * 4: Buy monthly subscription. - called from ExternalPaymentController.
	 * 5: Buy yearly subscription. - called from ExternalPaymentController.
	*/
	
	/**
	 * The method gets answer(true, false) and action to do. this method responsible for 
	 * purchasing books and subscriptions and to write the action in the DB.
	 * @param answer If "true" make a purchase, else cancel. 
	 * @param action The action what to do.
	 */
	
	public void makePurchase(boolean answer, int action)
	{
		/*
		if(answer == true)
		{
			if(action == 1 || action == 2 || action == 3) //buy book.
			{	
				ArrayList<String> buyBook = new ArrayList<>();
				User user = HomepageUserController.getConnectedUser();
				buyBook.add(user.getId());
				buyBook.add(searchedBookPage.getBookSn());
				buyBook.add(searchedBookPage.getBookPrice());
				buyBook.add(Integer.toString(action));	
				
				Message message = prepareBuy(ActionType.BUY_BOOK,buyBook);
				try {
					ClientController.clientConnectionController.sendToServer(message);
				} catch (IOException e) {	
					actionOnError(ActionType.TERMINATE,GeneralMessages.UNNKNOWN_ERROR_DURING_SEND);
				}
				
				Service<Void> service = new Service<Void>() {
			        @Override
			        protected Task<Void> createTask() {
			            return new Task<Void>() {           
			                @Override
			                protected Void call() throws Exception {                
			                    final CountDownLatch latch = new CountDownLatch(1);
			                    Platform.runLater(new Runnable() {                          
			                        @Override
			                        public void run() { 
			                        	PaymentRecv recv = new PaymentRecv();
			                	        recv.start();
			                	        synchronized(recv)
			                			{
			                				try {
			                					recv.wait();
			                				} catch (InterruptedException e1) {
			                					e1.printStackTrace();
			                				}

				                        	if(success == true)
				                        	{
				                        		BookPageController.searchedBookPage = searchedBookPage;
				                        		actionToDisplay(ActionType.CONTINUE,GeneralMessages.BOOK_PURCHASE_SUCCESS);
				                        		returnToPrevScreen(ScreensInfo.BOOK_PAGE_SCREEN);
				                        	}
			                			}
									}
			                        });
			                     latch.await();                      
			                     return null;
			                   }
			                };
			            }
			        };
			        service.start();
			}
			else if(action == 4 || action == 5)	//Buy subscription.
			{
				String credits;
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Date date = new Date();
				
				String dateGUIFormat="",dateDBFormat="";
				//String dateDBFormat = dateGUIFormat.replace('/', '-');
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				//System.out.println("Now:" + cal.getTime() + " , " + dateGUIFormat);
				if(action == 4)
				{
					cal.add(Calendar.MONTH, 1);  // number of months to add
					credits = "300";
				}
				else
				{
					cal.add(Calendar.YEAR, 1);  // number of years to add
					credits = "4000";
				}
				dateDBFormat = sdf.format(cal.getTime());  // dateDBFormat is now the new date
				dateDBFormat = sdf.format(cal.getTime());
				dateGUIFormat = dateDBFormat.replace('-','/');
				//System.out.println("Next:" + cal.getTime() + " , " + dateGUIFormat);
				
				
				ArrayList<String> buySubscription = new ArrayList<>();
				User user = HomepageUserController.getConnectedUser();
				buySubscription.add(user.getId());
				buySubscription.add(credits);
				buySubscription.add(dateGUIFormat);
				buySubscription.add(Integer.toString(action));	
				
				Message message = prepareBuy(ActionType.BUY_SUBSCRIPTION,buySubscription);
				try {
					ClientController.clientConnectionController.sendToServer(message);
				} catch (IOException e) {	
					actionOnError(ActionType.TERMINATE,GeneralMessages.UNNKNOWN_ERROR_DURING_SEND);
				}
				
				Service<Void> service = new Service<Void>() {
			        @Override
			        protected Task<Void> createTask() {
			            return new Task<Void>() {           
			                @Override
			                protected Void call() throws Exception {                
			                    final CountDownLatch latch = new CountDownLatch(1);
			                    Platform.runLater(new Runnable() {                          
			                        @Override
			                        public void run() { 
			                        	PaymentRecv recv = new PaymentRecv();
			                	        recv.start();
			                	        synchronized(recv)
			                			{
			                				try {
			                					recv.wait();
			                				} catch (InterruptedException e1) {
			                					e1.printStackTrace();
			                				}

				                        	if(success == true)
				                        	{
				                        		actionToDisplay(ActionType.CONTINUE,GeneralMessages.SUBSCRIPTION_PURCHASE_SUCCESS);
				                        		returnToPrevScreen(null);
				                        	}
				                        	
				                        	
				                        	if(success == false)
				                        		returnToPrevScreen(null);
			                			}
									}
			                        });
			                     latch.await();                      
			                     return null;
			                   }
			                };
			            }
			        };
			        service.start();
								
			}
		}
		else
		{
			if(action == 1)
			{
				BookPageController.searchedBookPage = searchedBookPage;
				returnToPrevScreen(ScreensInfo.BOOK_PAGE_SCREEN);
			}
			else if(action == 4 || action == 5)
				returnToPrevScreen(null);
		}
		*/
	}
	
	
	/**
	 * Make purchase in the DB.
	 * @param type The action type of the message that will pass to the server.
	 * @param elementList The parameters that will pass to the server.
	 * @return The message that will pass to the server.
	 */
	/*
	public Message prepareBuy(ActionType type, ArrayList<String> elementList)
	{
		Message message = new Message();
		message.setType(type);
		message.setElementsList(elementList);
		return message;
	}
	*/

	
	/* (non-Javadoc)
	 * @see interfaces.ScreensIF#actionOnError(enums.ActionType, java.lang.String)
	 */
	public void actionOnError(ActionType type, String errorCode) {
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText(errorCode);
		alert.showAndWait();
		if (type == ActionType.TERMINATE)
		{
			Platform.exit();
			System.exit(1);
		}
		if (type == ActionType.CONTINUE)
			return;
	}

	/**
	 * This method shows alert message after the action finished.
	 * @param type The action type of the message that will pass to the server.
	 * @param message The message that will pass to the server.
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
	 * Setter for success.
	 * @param success If the action was success.
	 */
	public void setSuccess(boolean success)
	{
		success = success;
	}

}
