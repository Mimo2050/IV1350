package se.kth.iv1350.POS.integration;
import se.kth.iv1350.POS.model.Receipt;
/**
* användargränssnittet till skrivaren som används för all utskrivning
* initierat av detta program.
*/
public class Printer {
	Printer(){
	}
	/**
	* skriver ut specifierat kvitto Prints the specified receipt.
	* Skriver ut till  <code>System.out</code> istället för skrivaren.
	*
	* @param kvitto
	*/
	public void printReceipt(Receipt receipt) {
		System.out.println(receipt.createReceiptString());
	}
}
