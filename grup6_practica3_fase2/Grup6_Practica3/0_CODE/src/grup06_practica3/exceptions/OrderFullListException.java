package grup06_practica3.exceptions;

/**
 * Author:  Aleix Marine Tena
 * Date:    03/11/16
 */
public class OrderFullListException extends Exception {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor for the OrderFullListException class
	 */
	public OrderFullListException() {
		super("Order cannot be added, list is full");
	}
}
