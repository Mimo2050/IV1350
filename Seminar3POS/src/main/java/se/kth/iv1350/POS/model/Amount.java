package se.kth.iv1350.POS.model;

import se.kth.iv1350.POS.model.Amount;
//import se.kth.iv1350.POS.DTOs.String;

/**
 * 
 * @author Abdullah
 *Klassen visar belopp som innehåller pengarna och valutan
 */
public class Amount {
	private String currency;
	private int amount;
	/**
	 * Skapa en instans av Amount
	 * @param amount    mängden pengar
	 * @param currency  valuta för pengarna
	 */
	public Amount (int amount, String currency) {
		this.currency = currency;
		this.amount =  amount;
	}
	/**
	 * @return mängden pengar
	 */
	public int getAmount() {
		return this.amount;
	}
	
	/**
	 * Utför subtraktion på specificerade antal objekt
	 * @param TermToSubtractWith termen som är subtraktorn
	 * @return Skillnad efter subtraktionsoperationen
	 */
	public int amountSubtraction(Amount TermToSubtractWith) {
		int diff = this.amount - TermToSubtractWith.amount;
		return diff;
	}
	
	public String toString() {
		return this.amount + " " + this.currency;
	}
	
	/**
	 * @return valuta
	 */
	public String getCurrency() {
		return this.currency;
	}
	
	public void addAmount(int amount) {
		this.amount += amount;
	}
}

