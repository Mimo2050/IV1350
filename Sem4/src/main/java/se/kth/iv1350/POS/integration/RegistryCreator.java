package se.kth.iv1350.POS.integration;
/**
 * 
 * @author Abdullah
 *Skapar alla register och returnera dem via creates all registries and returns them via "get-" metoder
 */
public class RegistryCreator {
	/**
	 * Skapar en instans av Registry Creator
	 */
	public RegistryCreator() {
		
	}
	
	public ItemRegistry getItemRegistry() {
		return new ItemRegistry();
	}
	public CustomerRegistry getCustomerRegistry() {
		return new CustomerRegistry();
	}

}
