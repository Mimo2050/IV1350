package se.kth.iv1350.POS.controller;
/**
 * 
 * @author murtadha
 *
 */
public class OperationFaliureException extends Exception {
	private static final long serialVersionUID = -1035587239582184082L;
	/**
	 * Creates a new instance with the given message and the root cause of this exception.
	 * @param message the message for the exception 
	 * @param cause the caused exception
	 */
	public OperationFaliureException(String message, Exception cause) {
		super(message, cause);
	}

}