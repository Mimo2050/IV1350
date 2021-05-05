package se.kth.iv1350.POS.startUp;
import se.kth.iv1350.POS.controller.Controller;
import se.kth.iv1350.POS.integration.*;
import se.kth.iv1350.POS.model.CashRegister;
import se.kth.iv1350.POS.view.View;
/**
 * @author Abdullah
 *
 */
public class Main {

	/**
	 * @param args
	 * Byta kommentaren i Main
	 */
	public static void main(String[] args) {
		RegistryCreator regCreator = new RegistryCreator();
		ExternalSystemGenerator extSys = new ExternalSystemGenerator();
		CashRegister cashRegister = new CashRegister();
		Controller contr = new Controller(regCreator, extSys, cashRegister);
        View view = new View(contr);
        view.runFakeSale();
	}
}
