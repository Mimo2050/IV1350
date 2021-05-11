package se.kth.iv1350.POS.model;
import se.kth.iv1350.POS.DTOs.*;
import se.kth.iv1350.POS.integration.*;
import java.util.ArrayList;
import java.util.List;
public class Sale {
	private Amount runningTotal = new Amount(0,"SEK");
	private List<ItemDTO> itemsInCurrentSale = new ArrayList<>();
	private Amount change;
	private Amount totalPriceAfterDiscount = new Amount (0, "SEK");
	private SaleDTO saleInfo;
	
	private List<SaleObserver> saleObservers = new ArrayList<>();
	
	/**
	 * Skapar en ny instans av Sale
	 */
	public Sale() {
		
	}
	
	/**
	 * adds a new observer to the list of sale observers which will be notified with total amount 
	 * when pay operation was handled. 
	 * @param saleObservers the observer that should be added to the list of sale observers
	 */
	public void addSaleObserver(SaleObserver saleObservers) {
		this.saleObservers.add(saleObservers);
	}
	
	private void notifyObservers(Amount totalPrice) {
		for(SaleObserver observer : this.saleObservers) {
			observer.newTotalPrice(totalPrice);
		}
	}
	
	/**
	 * lägger till en ny artikel i den aktuella försäljningen, uppdaterar den löpande summan inklusive moms
	 * @param itemInfo en instans av <code> ItemDTO </code> som innehåller information om en vara
	 * @param quantity antalet tillagda varor
	 * @return en instans av <code> SaleDTO </code> som innehåller information om aktuell försäljning
	 */
	public SaleDTO addItem(ItemDTO itemInfo) {
		this.itemsInCurrentSale.add(itemInfo);
		int quantity = itemInfo.getItemQuantity();
		updateRunningTotal(itemInfo, quantity);
		saleInfo = new SaleDTO(this.runningTotal, this.itemsInCurrentSale, this.change, this.totalPriceAfterDiscount);
		return saleInfo;
	}
	private void updateRunningTotal(ItemDTO itemInfo, int quantity) {
		Amount priceAfterVat = this.countItemPriceIncludinVAT(itemInfo);
		int amountOfPriceAfterVat = priceAfterVat.getAmount();
		int amountToUpdateRunningTotal = quantity *amountOfPriceAfterVat;
		this.runningTotal.addAmount(amountToUpdateRunningTotal);
	}
	private Amount countItemPriceIncludinVAT(ItemDTO itemInfo) {
		Amount priceOfItem = itemInfo.getPrice();
		int amountOfPrice = priceOfItem.getAmount();
		double vatRate = itemInfo.getVateRate();
		double priceIncludingVAT = amountOfPrice +(amountOfPrice * vatRate);
		int roundedPriceAfterVat = (int) Math.round(priceIncludingVAT);
		return new Amount(roundedPriceAfterVat,"SEK");
	}
	/**
	 * Kontrollerar om kunden är medlem eller inte och subtraherar rabatten från det totala priset
	 * @param customerID Ett kund-ID som sträng som representerar kundidentifikationen
	 * @param customerRegistry Är en databas där kunderna sparas
	 * @return Belopp Totalt pris
	 */
	public Amount countDiscount(String customerID,CustomerRegistry customerRegistry){
		DiscountRules discountRules = new DiscountRules();
		Amount totalAmount = this.runningTotal;
		double countedDiscount = totalAmount.getAmount();
		if(customerRegistry.isEligible(customerID)){
			countedDiscount = countedDiscount * (1- discountRules.discountRateMember(this.saleInfo));
		}
		else{
			countedDiscount = countedDiscount * (1 - discountRules.discountRateNotMember(this.saleInfo));
		}
		int roundedPriceAfterDiscount = (int) Math.round(countedDiscount);
		this.totalPriceAfterDiscount.addAmount(roundedPriceAfterDiscount);
		return this.totalPriceAfterDiscount;
	}
	
	/**
	 * beräknar ändringsbeloppet för att returnera till en kund.
	 * Och skapar en instans av <code> SaleDTO </code> som innehåller information om aktuell försäljning, inklusive ändringsbelopp
	 * @param amountPaid av kunden
	 * @return returnerar beloppet att få tillbaka efter betalning (växel)
	 */
	public Amount countPayment(Amount amountPaid) {
		int amountInChange = amountPaid.amountSubtraction(this.totalPriceAfterDiscount);
		this.change = new Amount(amountInChange, "SEK");
		saleInfo = new SaleDTO(this.runningTotal, this.itemsInCurrentSale, this.change, this.totalPriceAfterDiscount);
		
		notifyObservers(this.runningTotal);
		return this.change;
	}
	
	/**
	* skriver ut ett kvitto för nuvarande försäljning på en specifik skrivare
    */
	public void printReceipt(Printer printer) {
		Receipt receipt = new Receipt(saleInfo);
		printer.printReceipt(receipt);
	}
	
	public int getTotalPriceafterDiscount() {
		return this.totalPriceAfterDiscount.getAmount();
	}
}
	
