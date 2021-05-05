package se.kth.iv1350.POS.integration;
import se.kth.iv1350.POS.DTOs.*;
import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.POS.model.Amount;
public class ItemRegistry {
	private List<ItemDTO> items = new ArrayList<>();
	
	private final Amount JUICEPRICE = new Amount (10,"SEK");
	private final Amount PEPSIPRICE = new Amount (15,"SEK");
	private final Amount APPLEPRICE = new Amount (30,"SEK");
	private final double VAT10PERCENT = 0.1;
	private final double VAT15PERCENT = 0.15;
	private final double VAT20PERCENT = 0.2;
	private final String JUICEID = "asdf1234";
	private final String PEPSIID = "qwer1234";
	private final String APPLEID = "zxcv1234";
	
	
	/**
	 * Skapar en ny instans av Item Registry
	 */
	public ItemRegistry(){
		addItem();
	}
	/**
	 * Checkar om en vara som precis skannats finns i databasen
	 * @param itemIdentifier   identifikation av en vara
	 * @return ett objekt av typen <code >itemDTO</code> om det finns en annan vara med samma identifikation, annars <code>null</code>
	 */
	public ItemDTO findItem(String itemIdentifier) {
		ItemDTO itemInfo = null;
		for (ItemDTO item : items) {
			if (item.getItemID().equals(itemIdentifier)) {
				itemInfo = item;
			}
		}
		
		return itemInfo;
	}
	
	private void addItem() {
		items.add(new ItemDTO("Juice", JUICEPRICE, VAT10PERCENT, JUICEID));
		items.add(new ItemDTO("Pepsi", PEPSIPRICE,VAT15PERCENT, PEPSIID));
		items.add(new ItemDTO("Apple", APPLEPRICE, VAT20PERCENT, APPLEID));
		
		
	}
}
