package se.kth.iv1350.POS.DTOs;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.POS.model.Amount;

/**
 * detta är en platshållare för försäljningsinformation
 * @author Abdullah
 *
 */
public class SaleDTO {
	private Amount runningTotal;
	private List<ItemDTO> itemsInCurrentSale = new ArrayList<>();
	private Amount change;
	private Amount totalPriceAfterDiscount;
	
	/**
	 * skapar en ny instans som representerar en ny försäljning
	 * @param  runningTotal     totalpris efter skanning av varje vara
	 * @param  itemInfo         en instans av itemDTO som är en platshållare för information om ett objekt
	 */
	public SaleDTO(Amount runningTotal,List <ItemDTO> itemInfo, Amount change, Amount totalPriceAfterDiscount) {
		this.runningTotal = runningTotal;
		this.itemsInCurrentSale = itemInfo;
		this.change = change;
		this.totalPriceAfterDiscount = totalPriceAfterDiscount;
	}
	
	/**
	 * returnerar running total
	 *@return running total för varje försäljning
	 */
	public Amount getRunningTotal() {
		return this.runningTotal;
	}
	
	public Amount getChange() {
		return this.change;
	}
	
	/**
	 * returnerar information om ett objekt som en instans av ItemDTO
	 *@return namn på en vara
	 */
	public List<ItemDTO> getItemInfo() {
		return this.itemsInCurrentSale;
	}
	
	
	public Amount getTotalPriceAfterDiscount() {
		return this.totalPriceAfterDiscount;
	}
}
