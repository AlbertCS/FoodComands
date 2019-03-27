package grup06_practica3.exceptions;

/**
 * Author:  Bernat Bosca Candel
 * Date:    03/11/16
 */
public class ClientNotFoundException extends Exception {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor for the ClientNotFoundException class
	 */
	public ClientNotFoundException() {
		super("Client cannot be found");
	}
}
