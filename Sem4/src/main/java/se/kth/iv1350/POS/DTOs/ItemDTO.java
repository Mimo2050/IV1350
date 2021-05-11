package se.kth.iv1350.POS.DTOs;

import se.kth.iv1350.POS.model.Amount;

/**
 * 
 * @author Abdullah
 *innehåller information om en vara
 */
public class ItemDTO {
	private String name ;
	private Amount price;
	private double vatRate;
	private String itemIdentifier;
	private int itemQuantity;
	
	/**
	 * Skapar en ny instans som representerar en ny vara
	 * @param  name                     av varan
	 * @param  price     		av varan
	 * @param  vatRate 	 procentuella andelen av moms för var enda vara
	 * @param  itemIdentifier
	 */
	public ItemDTO(String name, Amount price, double vatRate, String itemIdentifier) {
		this.name = name;
		this.price = price;
		this.vatRate = vatRate;
		this.itemIdentifier = itemIdentifier;
	}
	
	/**
	 * Returnerar en varas namn
	 * @return namnet av en vara
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 *returnerar priset på en vara
	 *@return priset på en vara
	 */
	public Amount getPrice() {
		return this.price;
	}
	
	/**
	 *Returnerar momsandel av priset på en vara
	 *@return momsandel av varans pris
	 */
	public double getVateRate() {
		return this.vatRate;
	}
	
	/**
	 * Returnerar en varas ID
	 *@return varans ID
	 */
	public String  getItemID() {
		return this.itemIdentifier;
	}
	/**
	 * Sätterantalet varor som ska läggas till i försäljning
	 * @param itemQuantity antalet tillagda varor
	 */
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	public int getItemQuantity() {
		return this.itemQuantity;
	}
}
