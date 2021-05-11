package se.kth.iv1350.POS.integration;

/**
 * 
 */
public class ItemRegistryException extends RuntimeException {

	private static final long serialVersionUID = -6272626728679110915L;
	/**
	 * creates a new instance specifying what went wrong by the specified message 
	 * @param message a message that specifies what went wrong 
	 */
	public ItemRegistryException(String message) {
		super(message);
	}
	
	/**
	 * creates a new instance specifying what went wrong by message 
	 * and the root cause
	 * @param message
	 * @param cause
	 */
	public ItemRegistryException(String message, Exception cause) {
		super (message, cause);
	}
}
