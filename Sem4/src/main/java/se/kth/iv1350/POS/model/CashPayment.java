package se.kth.iv1350.POS.model;


/**
* Representerar en specifik betalning för en specifik försäljning.
* Försäljningen betalas med kontanter.
*/
public class CashPayment {
	private Amount amtPaid;
	/**
	* Skapar en ny instans.  Kunden överlämnar den specifika summan
	*
	* @param amtPaid det beloppet som kunden lämnat
	*/
	public CashPayment(Amount amtPaid) {
		this.setAmtPaid(amtPaid);
	}
	public Amount getAmtPaid() {
		return amtPaid;
	}
	public void setAmtPaid(Amount amtPaid) {
		this.amtPaid = amtPaid;
	}
}
