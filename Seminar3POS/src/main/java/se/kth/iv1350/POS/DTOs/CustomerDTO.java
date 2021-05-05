package se.kth.iv1350.POS.DTOs;
/**
 * 
 * @author Murtadha
 *Innehåller information om en kund
 */
public class CustomerDTO {
    private String customerName;
    private String customerID;

    /**
	 * Skapar a ny instans som representerar en ny kund
	 * @param  customerName
	 * @param  customerID
	 */


    public CustomerDTO(String customerName, String customerID){
        this.customerName = customerName;
        this.customerID = customerID;


    }

    /**
     * Returnerar namn av en kund
     * @return kundnamn
     */
    public String getCustomerName(){
        return this.customerName;
    }

    /**
     * @return kund-ID
     */
    public String getCustomerID(){
        return this.customerID;
    }


}

