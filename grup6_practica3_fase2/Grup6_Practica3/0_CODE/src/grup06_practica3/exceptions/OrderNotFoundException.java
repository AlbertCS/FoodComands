package grup06_practica3.exceptions;

/**
 * Author:  Aleix Marine Tena
 * Date:    03/11/16
 */
public class OrderNotFoundException extends Exception {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor for the OrderNotFoundException class
	 */
	public OrderNotFoundException() {
		super("Order cannot be found");
	}
}
