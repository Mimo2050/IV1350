package se.kth.iv1350.POS.view;
import java.io.IOException;

import se.kth.iv1350.POS.DTOs.SaleDTO;
import se.kth.iv1350.POS.controller.Controller;
import se.kth.iv1350.POS.controller.InvalidItemIdentifierException;
import se.kth.iv1350.POS.controller.OperationFaliureException;
import se.kth.iv1350.POS.model.Amount;

import util.*;



public class View {
	 private Controller contr;
	 private ExceptionMessagePrinter excMsgPrinter = new ExceptionMessagePrinter();
	 private LogHandlar loghandlar;
	    
	 /**
	  * creates a new instance of view 
	  * @param contr a reference to class <code>Controller</code> 
	  */
	 public View(Controller contr) throws IOException {
		 this.contr = contr;
	     this.loghandlar = new LogHandlar();
	 }
	    /**
	     * a fake method which is used instead of real user interface
	     */
	    
	    public void runFakeSale() {
	    	contr.newSale();
   		System.out.println("New sale was started.");
   		this.contr.addSaleObserver(new TotalRevenueView());
   		String itemIdentifier = "zxcv123";
   		
	    	try {	
	    		SaleDTO saleInfo = contr.addItem(itemIdentifier, 4);
	    		
	    		int value = saleInfo.getRunningTotal().getAmount();
	    		System.out.println("the item was added successfully \n "
	    				+ "running total is:" + value); 
	    		String customerID = "asdf1234";
	    		Amount priceAfterDiscount =contr.discountRequest(customerID);
	    		System.out.println("Discount has been added successfully. Discount Amount is: "+ priceAfterDiscount);
	    		Amount change = contr.pay(new Amount(1000, "SEK"));
	    		System.out.println("The payment has been handled. Change is equal to " + change);
	    	}
	    	catch(InvalidItemIdentifierException exc){
	    		handleException(exc.getMessage(), exc);
	    	}
	    	catch(OperationFaliureException exc){
	    		handleException(exc.getMessage(), exc);
	    	}
	    }
	    
	    private void handleException(String msg, Exception exc) {
	    	excMsgPrinter.printExceptionMessage(msg);
	    	loghandlar.logException(exc);
	    }
}
