package grup06_practica3.exceptions;

/**
 * Author:  Aleix Marine Tena
 * Date:    03/11/16
 */
public class OrderLineFullListException extends Exception {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor for the OrderLineFullListException class
	 */
	public OrderLineFullListException() {
		super("OrderLine cannot be added, list is full");
	}
}
