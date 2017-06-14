package cardGame;

import java.lang.RuntimeException;

/**
 * An exception that is thrown when stack operations fail. 
 * @author Nick Ruiz
 * @version 1.0
 */
public class StackException extends RuntimeException {
	/**
	 * Constructs an exception with a specified message. 
	 * @param message The specified message of this exception
	 */
	public StackException(String message) {
		super(message);
	}
}
