package grup06_practica3.exceptions;

/**
 * Author:  Aleix Marine Tena
 * Date:    03/11/16
 */
public class OrderLineNotFoundException extends Exception {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor for the OrderLineNotFoundException class
	 */
	public OrderLineNotFoundException() {
		super("OrderLine cannot be found");
	}
}
