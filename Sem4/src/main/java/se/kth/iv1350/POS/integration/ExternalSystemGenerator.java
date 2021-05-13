package se.kth.iv1350.POS.integration;

/**
* denna klass ansvarar för This class is responsible för att starta alla externa system.
*/
public class ExternalSystemGenerator {
	/**
	 * Hämta värdet från skrivaren
	 * @return värdet som skrivaren ger ut 
	 */
	public Printer getPrinter() {
		return new Printer();
	}
}
