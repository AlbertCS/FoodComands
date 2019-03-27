package grup06_practica3.exceptions;

/**
 * Author:  Marc Cabre Guinovart
 * Date:    03/11/16
 */
public class ProductFullListException extends Exception {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor for the ProductFullListException class
	 */
	public ProductFullListException() {
		super("Product cannot be added, list is full");
	}
}
