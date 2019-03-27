package grup06_practica3.exceptions;

/**
 * Author:  Bernat Bosca Candel
 * Date:    03/11/16
 */
public class ClientFullListException extends Exception {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor for the ClientFullListException class
	 */
	public ClientFullListException() {
		super("Client cannot be added, list is full");
	}
}
