package headers.models;

/**
 * Author:  Albert Canellas Sole
 * Date:    20/11/16
 */
public interface Product_H {

	/**
	 * Gets the unique identifier of the product
	 *
	 * @return unique identifier of the product
	 */
	int getCode();

	/**
	 * Gets the name of the product
	 *
	 * @return name of the product
	 */
	String getName();

	/**
	 * Gets the price of the product
	 *
	 * @return price of the product
	 */
	double getPrice();

	/**
	 * Gets the discount of the product if the client is vip
	 *
	 * @return discount of the product if the client is vip
	 */
	double getDiscount();
}
