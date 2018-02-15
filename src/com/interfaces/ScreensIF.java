package com.interfaces;

import java.io.IOException;

/*import java.net.URL;
import java.util.ResourceBundle;*/

import com.enums.ActionType;
import javafx.event.ActionEvent;


public interface ScreensIF {
	

	public void pressedCloseMenu(ActionEvent event) throws IOException;
	
	
	/**
	 * This function gets message and perform the task by the error type.
	 * @param type Gets error type.
	 * @param errorCode Gets error message.
	 */
	public void actionOnError(ActionType type, String errorCode);
	
}
