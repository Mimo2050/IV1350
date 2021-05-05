package se.kth.iv1350.POS.view;
import se.kth.iv1350.POS.controller.*;
import se.kth.iv1350.POS.DTOs.*;
import se.kth.iv1350.POS.model.Amount;
public class View {
	 private Controller contr;
	    
	    public View(Controller contr) {
	        this.contr = contr;
	    }
	    /**
	     * en falsk metod som används istället för ett riktigt user interface
	     */
	    
	    public void runFakeSale() {
	        contr.newSale();
	        System.out.println("New sale was started.");
	        String itemIdentifier = "asdf1234";
	        SaleDTO saleInfo = contr.addItem(itemIdentifier, 4);
	        int value = saleInfo.getRunningTotal().getAmount();
	        System.out.println("the item was added successfully \n "
	        		+ "running total is:" + value); 
	        String customerID = "123ABC";
	        Amount priceAfterDiscount =contr.discountRequest(customerID);
	        System.out.println("Discount has been added successfully Discount Amount is:"+ priceAfterDiscount);
	        Amount change = contr.pay(new Amount(200, "SEK"));
	        System.out.println("The pay has been handled. Change is equal to " + change);
	    }
}
