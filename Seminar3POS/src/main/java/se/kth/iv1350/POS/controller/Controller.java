package se.kth.iv1350.POS.controller;

import se.kth.iv1350.POS.model.*;
import se.kth.iv1350.POS.DTOs.*;
import se.kth.iv1350.POS.integration.*;
import se.kth.iv1350.POS.integration.ExternalSystemGenerator;
import se.kth.iv1350.POS.integration.Printer;

public class Controller {
	    private Sale sale;
	    private ExternalSystemGenerator extSys;
	    private CashRegister cashRegister;
	    private RegistryCreator regCreator;
	    /**
	     * Skapar en instans av Controller som kopplar alla anrop från vy till klasser i modell och klasser i
	     * integrationslager
	     */
	    public Controller(RegistryCreator regCreator, ExternalSystemGenerator extSys, CashRegister cashRegister) {
	    	this.cashRegister = cashRegister;
	    	this.extSys = extSys;
	    	this.regCreator = regCreator;
	    }
	    
	    /**
	     * Startar en ny försäljning genom att göra en instans av Sale-objekt.
	     */
	    public Sale newSale() {
	        this.sale = new Sale();
	        return this.sale;
	    }
	    
	    /**
	     * lägga till en vara till nuvarande försäljning
	     * @param itemIdentifier   det som identifierar en vara (streckkod)
	     * @param itemQuantitiy     antalet varor
	     * @return returnerar en objekt av typen <code>SaleDTO</code> som ineehåller information om            priset på en vara, moms och totalt pris
	     */
	    public SaleDTO addItem(String itemIdentifier, int itemQuantity) {
	    	SaleDTO currentSale = null; 
	    	ItemRegistry itemRegistry =  regCreator.getItemRegistry();
	    	ItemDTO itemInfo = itemRegistry.findItem(itemIdentifier);
	    	if (itemInfo != null) {
	    		itemInfo.setItemQuantity(itemQuantity);
	    		currentSale = this.sale.addItem(itemInfo);	    		
	    	}
	    	return currentSale;
	    }
	    /**
	     * Göra en förfråga om rabatt på nuvarande försäljning
	     * @param CustomerID är en sträng som representerar kundens identifikation
	     * @return returnerar objektet Amount och innehåller det totala priset
	     */
	    public Amount discountRequest(String CustomerID){
	    	CustomerRegistry customerRegistry = regCreator.getCustomerRegistry();
	        Amount totalPriceAfterDiscount = sale.countDiscount(CustomerID, customerRegistry);
	    	return totalPriceAfterDiscount;
		}
	    
	     
	    /**
	     * Behandlar betalning för försäljning. Updaterar Cash Register och sparar betalningen.
	     * Räknar ut det som kunden får tillbaka (växel). Skriver ut kvitto
	     * @param amtPaid det betalda beloppet
	     * @return hur mycket pengar som kunden får tillbaka
	     */
	    public Amount pay(Amount amtPaid) {
	    	Amount change = sale.countPayment(amtPaid);
	    	CashPayment payment = new CashPayment(amtPaid);
	    	cashRegister.recordPayment(payment);
	    	Printer printer = extSys.getPrinter();
	    	sale.printReceipt(printer);
	    	return change;
	    }
}
