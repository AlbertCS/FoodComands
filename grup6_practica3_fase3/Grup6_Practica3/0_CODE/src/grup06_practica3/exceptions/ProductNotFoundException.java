package grup06_practica3.exceptions;

/**
 * Author:  Marc Cabre Guinovart
 * Date:    03/11/16
 */
public class ProductNotFoundException extends Exception {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor for the ProductNotFoundException class
	 */
	public ProductNotFoundException() {
		super("Product cannot be found");
	}
}
