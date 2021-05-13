package se.kth.iv1350.POS.view;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class ExceptionMessagePrinter {

	void printExceptionMessage(String msg) {
		StringBuilder excMessageBuilder = new StringBuilder();
		excMessageBuilder.append(getCurrentTime());
		excMessageBuilder.append("; some error has been occured: \n ");
		excMessageBuilder.append(msg);
		System.out.println(excMessageBuilder);
		
	}
	
	private String getCurrentTime() {
		 DateFormat dateFormate = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	     Date currentDateAndTime = new Date();
	     return dateFormate.format(currentDateAndTime).toString();
	}
}
